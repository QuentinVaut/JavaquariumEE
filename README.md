Start a DB for dev with Docker: 

```bash
docker run -d \
  -p 3306:3306 \
  -e MYSQL_ALLOW_EMPTY_PASSWORD=yes \
  -e MYSQL_DATABASE=javaquarium \
  --name=javaquarium-db \
  mysql;
```
