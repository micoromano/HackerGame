FROM public.ecr.aws/docker/library/openjdk:17.0.2-jdk-slim

# To build image in multiarch
RUN ln -s /usr/bin/dpkg-split /usr/sbin/dpkg-split && ln -s /usr/bin/dpkg-deb /usr/sbin/dpkg-deb && ln -s /bin/tar /usr/sbin/tar
RUN apt-get update && apt-get -y install bash curl

ADD HackerGame-1.0.0-alpha.1.jar HackerGame-1.0.0-alpha.1.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", " java -XX:MinHeapFreeRatio=5 -XX:MaxHeapFreeRatio=10 -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -Xms100M -jar HackerGame-1.0.0-alpha.1.jar -XX:+UseShenandoahGC"]
