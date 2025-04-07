# Theorem (Python)

---

The ```Theorem``` represents the python project.

## Project Structure

Although this layout is pretty straightforward, it has several drawbacks that arise as the app complexity increases. 
For example, it will be hard for you to reuse the application logic in other projects because all the functionality is bundled in ```webapp/__init__.py```. 
If you split this functionality into modules instead, then you could reuse complete modules across different projects.

```
    /
    ├── adts                            # an adts package/
    │    ├── array                      # an array package/
    │    ├── graph                      # a graph package/
    │    │    ├── __init__.py           # The package initializer
    │    │    ├── README.md             # Instructions and helpful links
    │    │    └── _                     # The package initializer
    │    ├── hash                       # a hash package/
    │    ├── heap                       # a heap package/
    │    ├── iterator                   # an iterator package/
    │    ├── lang                       # a lang package/
    │    ├── linkedlist                 # a linkedlist package/
    │    ├── list                       # a list package/
    │    ├── logs                       # a logs package/
    │    ├── map                        # a map package/
    │    ├── queue                      # a queue package/
    │    ├── search                     # a search package/
    │    ├── security                   # a security package/
    │    ├── sort                       # a sort package/
    │    ├── stack                      # a stack package/
    │    ├── text                       # a text package/
    │    ├── time                       # a time package/
    │    ├── tree                       # a tree package/
    │    ├── trie                       # a trie package/
    │    ├── __init__.py                # The package initializer
    │    └── README.md                  # The README file of ews module
    ├── algos                           # an algos package/
    │    ├── array                      # an array package/
    │    ├── graph                      # a graph package/
    │    │    ├── __init__.py           # The package initializer
    │    │    ├── README.md             # Instructions and helpful links
    │    │    └── _                     # The package initializer
    │    ├── hash                       # a hash package/
    │    ├── heap                       # a heap package/
    │    ├── iterator                   # an iterator package/
    │    ├── lang                       # a lang package/
    │    ├── linkedlist                 # a linkedlist package/
    │    ├── list                       # a list package/
    │    ├── logs                       # a logs package/
    │    ├── map                        # a map package/
    │    ├── queue                      # a queue package/
    │    ├── search                     # a search package/
    │    ├── security                   # a security package/
    │    ├── sort                       # a sort package/
    │    ├── stack                      # a stack package/
    │    ├── text                       # a text package/
    │    ├── time                       # a time package/
    │    ├── tree                       # a tree package/
    │    ├── trie                       # a trie package/
    │    ├── __init__.py                # The package initializer
    │    └── README.md                  # The README file of ews module
    ├── aptitude                        # an aptitude package/
    ├── domain                          # a domain package/
    ├── games                           # a games package/
    ├── quiz                            # a quiz package/
    ├── README.md                       # Instructions and helpful links
    ├── requirements.txt                # a list of package dependencies
    └── robots.txt                      # tells which URLs the search engine crawlers can access on your site
```

## Local Development

### Check python settings
```shell
python3 --version
python3 -m pip --version
python3 -m ensurepip --default-pip
```

### Setup a virtual environment

```
python3 -m pip install virtualenv
python3 -m venv venv
source deactivate
source venv/bin/activate
```

**Note: -**
```source``` is Linux/Mac-OS command and doesn't work in Windows.

- Windows
```shell
venv\Scripts\activate
```

**Note: -**
The parenthesized (venv) in front of the prompt indicates that you’ve successfully activated the virtual environment.


### Install Requirements (Dependencies)

```
pip install --upgrade pip
python3 -m pip install -r iws/requirements.txt
```


- Install Flask

**Note**: - Only if you didn't install the 'requirements.txt' file.

```shell
python3 -m pip install Flask
```


### Configuration Setup

Create or update local .env configuration file.

```shell
cp ./iws/default.env .env
OR
touch .env

#
# App Configs
#
FLASK_ENV = development
DEBUG = False
HOST = 127.0.0.1
PORT = 8080
#
# Pool Configs
#
DEFAULT_POOL_SIZE = 1
RDS_POOL_SIZE = 1
#
# Logger Configs
#
LOG_FILE_NAME = 'iws.log'
#
# Database Configs
#
DB_HOSTNAME = 127.0.0.1
DB_PORT =
DB_NAME = posts
DB_USERNAME = posts
DB_PASSWORD = Password
```


### Run IWS Flask Application

**By default**, Flask runs the application on **port 5000**.


```shell
python wsgi.py

OR

#flask --app wsgi run
python -m flask --app wsgi run
# http://127.0.0.1:5000/posts

OR

python -m flask --app wsgi run --port 8080 --debug
# http://127.0.0.1:8080/posts

OR

# Production Mode

# equivalent to 'from app import app'
gunicorn wsgi:app
# gunicorn -w <n> 'wsgi:app'
gunicorn -w 2 'wsgi:app'
# http://127.0.0.1:8000/posts

gunicorn -c gunicorn.conf.py wsgi:app
# http://127.0.0.1:8080/posts

```

**Note**:- You can stop the development server by pressing ```Ctrl+C``` in your terminal.

### Access Flask Application
- [IWS on port 8080](http://127.0.0.1:8080/posts)
- [IWS on port 8000](http://127.0.0.1:8000/posts)
- [IWS on port 5000](http://127.0.0.1:5000/posts)


### Build Project
```shell
python3 -m build
```

### Save Requirements (Dependencies)
```shell
pip freeze > requirements.txt
```


## Testing


### Unit Tests
```shell
python3 -m unittest
python -m unittest discover -s ./tests -p "test_*.py"
```

### Performance Testing
```shell
# Run this in a separate terminal
# so that the load generation continues and you can carry on with the rest of the steps
kubectl run -i --tty load-generator --rm --image=busybox:1.28 --restart=Never -- /bin/sh -c "while sleep 0.01; do wget -q -O- http://php-apache; done"
```


# Reference

- [Build a Scalable Flask Web Project From Scratch](https://realpython.com/flask-project/)
- [Gunicorn - WSGI server](https://docs.gunicorn.org/en/latest/index.html)
- [Python Packaging User Guide](https://packaging.python.org/en/latest/)
- [The Twelve Factors App](https://12factor.net/)
- [werkzeug examples](https://github.com/pallets/werkzeug/tree/main/examples)

### Logger Guide
- [Logging HOWTO](https://docs.python.org/3/howto/logging.html)

### Documentation
- [Documentation generator and online help system](https://docs.python.org/3/library/pydoc.html)

### Load Balancing
- [Load Balancing: The Intuition Behind the Power of Two Random Choices](https://medium.com/the-intuition-project/load-balancing-the-intuition-behind-the-power-of-two-random-choices-6de2e139ac2f)
- [Load Balancing](https://go-zero.dev/en/docs/tutorials/service/governance/lb)



### Concepts - Data Structure & Algorithms

| Topic      | Types                                                                                                                                                                                                                         | Description                                                 |
|:-----------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|
| Array      | <ul><li>Single Dimension</li><li>Multi-Dimension</li></ul>                                                                                                                                                                    |                                                             |
| Clock      | <ul><li>Vector Clock</li><li>Lamport Clock</li></ul>                                                                                                                                                                          |                                                             |
| List       | <ul><li>ArrayList</li></ul>                                                                                                                                                                                                   |                                                             |
| LinkedList | <ul><li>Singly Linked List</li><li>Doubly Linked List</li></ul>                                                                                                                                                               |                                                             |
| Set        | <ul><li>Ordered</li><li>Unordered</li></ul> Implementations <ul><li>Hash Set</li><li>Sorted Set</li><li>Tree Set</li></ul>                                                                                                    |                                                             |
| Map        | <ul><li>HashMap</li><li>LinkedHashMap</li><li>ConcurrentHashMap</li></ul>                                                                                                                                                     |                                                             |
| Sort       | Sorting Methods <ul><li>Bubble Sort</li><li>Insertion Sort</li><li>Selection Sort</li><li>Merge Sort</li><li>Heap Sort</li><li>Cyclic Sort</li><li>Topological Sort</li></ul>                                                 | Sorting Types <ul><li>Ascending</li><li>Decending</li></ul> |
| Search     | <ul><li>Binary Search</li></ul>                                                                                                                                                                                               |                                                             |
| Stack      |                                                                                                                                                                                                                               |                                                             |
| Queue      | <ul><li>Circular Queue</li><li>Blocked Queue</li><li>Priority Queue</li><li>Indexed Priority Queue</li></ul>                                                                                                                  |                                                             |
| Heap       | <ul><li>Min Heap</li><li>Max Heap</li><li>Priority Queue</li></ul>                                                                                                                                                            |                                                             |
| Tree       | Traversal Methods <ul><li>Depth First Search (Uses Stack)</li><li>Breadth First Search (Users Queue)</li></ul> Tree Types <ul><li>Binary Tree</li><li>Binary Search Tree</li><li>Spanning Tree</li><li>Segment Tree</li></ul> |                                                             |
| Graph      | Graph Components <ul><li>Vertex</li><li>Edge<ul><li>Directed</li><li>Undirected</li></ul></li></ul>                                                                                                                           |                                                             |

## References

---

- [Lamport Clocks](https://sookocheff.com/post/time/lamport-clock)
- [Lamport Clocks: Determining the Order of Events in Distributed Systems](https://medium.com/outreach-prague/lamport-clocks-determining-the-order-of-events-in-distributed-systems-41a9a8489177)
- [Lamport Logical Clock](https://www.geeksforgeeks.org/lamports-logical-clock)
- [Vector Clock](https://en.wikipedia.org/wiki/Vector_clock)
- [Time in Distributed Systems Lamport Timestamps](https://www.goodmath.org/blog/2016/03/16/time-in-distributed-systems-lamport-timestamps)
- 



# Author
- Rohtash Lakra
