# SQLPractice
Set up a Postgres database:
>docker run --rm --name some-postgres -it -e POSTGRES_PASSWORD=password -v [path to]\SQLPractice\init.sql:/docker-entrypoint-initdb.d/init.sql -p 5432:5432 postgres