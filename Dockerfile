FROM openjdk:16
COPY . /myapp/
WORKDIR /myapp/
RUN javac -cp src/ src/Lexer.java -d dst/