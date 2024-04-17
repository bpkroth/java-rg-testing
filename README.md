# java-rg-testing

## Terminal 1

Run a test program that prints the number of processes detected and sleeps for a moment before repeating.

```sh
docker run --rm --cpus 2 --cpuset-cpus 2-3 --name java-rg-testing -v $PWD/src:/src openjdk:21 java /src/JavaRgInfo.java 2 600
```

## Terminal 2

Adjust the cgroup settings dynamically and watch the test program dynamically adjust:

```sh
docker update --cpus 1 java-rg-testing # prints 1 available processor
```

```sh
docker update --cpus 1 --cpuset-cpus 2-5 java-rg-testing # prints 1 available processor even though cpuset increased
```

```sh
docker update --cpus 16 --cpuset-cpus 2-5 java-rg-testing # prints 4 since cpuset is the limit
```

