# ViewTheQueue
A Spring REST service for getting wait times and other information about Attractions, Restaurants and Shows at a Themed Entertainment Resort.

# Author
James Hare

Email: harejamesm@gmail.com

LinkedIn: https://www.linkedin.com/in/jameshareuk

# Setup
#### Install Local Postgres Instance
Use the `docker-compose.yml` file from the project root directory to stand up a local instance of postgres.

This will create a database named dev and an admin user.

Use pgAdmin to connect to your database as admin.  Run the following queries to create a user for the view-the-queue-service application:

```sql
CREATE SCHEMA view_the_queue;
CREATE USER view_the_queue WITH PASSWORD 'viewthequeue1';
ALTER DEFAULT PRIVILEGES IN SCHEMA view_the_queue GRANT ALL PRIVILEGES ON TABLES TO view_the_queue;
GRANT ALL ON SCHEMA view_the_queue TO view_the_queue;
ALTER ROLE view_the_queue SET search_path TO view_the_queue;
grant view_the_queue to admin;
ALTER DEFAULT PRIVILEGES FOR ROLE view_the_queue GRANT INSERT, UPDATE, DELETE, TRUNCATE ON TABLES TO admin;
```
