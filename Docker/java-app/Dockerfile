FROM openjdk:17
WORKDIR /app

# Copy Java source code
COPY emp/ emp/
COPY postgresql-42.7.5.jar .

# Compile Java code
RUN javac -cp postgresql-42.7.5.jar -d . emp/*.java

# Run the Java application
CMD ["java", "-cp", ".:postgresql-42.7.5.jar", "emp.Main"]
