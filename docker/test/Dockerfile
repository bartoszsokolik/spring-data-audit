FROM openjdk:11-jre-slim
ADD ./target/application.jar application.jar

ADD ./run.sh /run.sh
RUN chmod +x /run.sh

ADD ./wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

CMD ["/run.sh"]