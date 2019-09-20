FROM maven:3.6.2 as builder

WORKDIR /workspace
COPY . .
RUN mvn clean install -P installation && \
mkdir output && \
cp ./target/application.jar output/application.jar

FROM openjdk:11-jre-slim
COPY --from=builder /workspace/output/* ./

ADD ./run.sh /run.sh
RUN chmod +x /run.sh

ADD ./wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

CMD ["/run.sh"]