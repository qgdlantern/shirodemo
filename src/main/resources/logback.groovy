appender('CONSOLE', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = '%d{HH:mm:ss} %-5level %msg%n'
    }
}
root(INFO, ['CONSOLE'])
