package com.devamatre.theorem.algos.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Nov 27, 2020 16:28:25
 */
public class WebCrawler {

    private String rootUrl;
    private Queue<String> queue = new LinkedList<>();
    private Set<String> discovered = new HashSet<>();
    private static final String UTF_8 = StandardCharsets.UTF_8.name();
    private static final String REGEX_URL = "(http|https)://(\\w+\\.)*(\\w+)";
    private static final Pattern REGEX_URL_PATTERN = Pattern.compile(REGEX_URL);

    public WebCrawler(final String rootUrl) {
        this.rootUrl = rootUrl;
        if (this.rootUrl != null && this.rootUrl.trim().length() > 0) {
            queue.offer(this.rootUrl);
            discovered.add(this.rootUrl);
        }
    }

    /**
     * Reads the contents of the file.
     *
     * @param urlString
     * @return
     */
    private String readContents(final String urlString) {
        final StringBuilder fileBuilder = new StringBuilder();
        URLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        try {
            urlConnection = new URL(urlString).openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), UTF_8));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileBuilder.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return fileBuilder.toString();
    }

    /**
     * Processes the contents of the given url.
     *
     * @param url
     */
    private void processContents(final String url) {
        String fileContents = readContents(url);
        Matcher matcher = REGEX_URL_PATTERN.matcher(fileContents);
        while (matcher.find()) {
            String nextUrl = matcher.group();
            if (!discovered.contains(nextUrl)) {
                discovered.add(nextUrl);
                queue.offer(nextUrl);
            }
        }
    }

    /**
     * Do BFS to each url.
     */
    public void start() {
        while (!queue.isEmpty()) {
            String url = queue.poll();
            System.out.println("Processing [" + url + "]");
            // read the url contents and find linked pages
            processContents(url);
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler("https://www.devamatre.com");
        webCrawler.start();
    }
}
