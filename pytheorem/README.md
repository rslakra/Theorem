# PyTheorem (Python)

---

The ```PyTheorem``` project contains the algorithms, abstract data types and implementation of them including the
interview preparation algorithms in ```Python``` language.


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

### Check ```Python``` settings
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
```source``` is ```Linux/Mac-OS``` command and doesn't work in ```Windows```.

- Windows
```shell
venv\Scripts\activate
```

**Note: -**
The parenthesized ```(venv)``` in front of the prompt indicates that you’ve successfully activated the virtual environment.


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

Create or update local ```.env``` configuration file.

```shell
cp ./default.env .env
OR
touch .env

#
# App Configs
#
FLASK_ENV = develop
DEBUG = False
HOST = 0.0.0.0
PORT = 8080
#
# Pool Configs
#
DEFAULT_POOL_SIZE = 1
RDS_POOL_SIZE = 1
#
# Logger Configs
#
LOG_FILE_NAME = 'PyTheorem.log'
#
# Database Configs
#
DB_HOSTNAME = 127.0.0.1
DB_PORT =
DB_NAME = PyTheorem
DB_USERNAME = PyTheorem
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

### Python Basics

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


### Events in Distributed Systems
- [Lamport Clocks](https://sookocheff.com/post/time/lamport-clock)
- [Lamport Clocks: Determining the Order of Events in Distributed Systems](https://medium.com/outreach-prague/lamport-clocks-determining-the-order-of-events-in-distributed-systems-41a9a8489177)
- [Lamport Logical Clock](https://www.geeksforgeeks.org/lamports-logical-clock)
- [Vector Clock](https://en.wikipedia.org/wiki/Vector_clock)
- [Time in Distributed Systems Lamport Timestamps](https://www.goodmath.org/blog/2016/03/16/time-in-distributed-systems-lamport-timestamps)

### Makefile
- [6.14 Other Special Variables](https://www.gnu.org/software/make/manual/html_node/Special-Variables.html)


# Author

---

- Rohtash Lakra
