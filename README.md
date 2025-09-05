# Benchmark UUID7 Primary Key vs BIGINT Primary Key Performance in PostgreSQL

Just a very simple repository to benchmark the performance of UUID7 primary keys vs BIGINT primary keys in PostgreSQL.

You can start the application and use the shell to execute the following commands:

Help:
```shell
help
```

Test with BIGINT:
```shell
run-int-insert
```

Test with UUIDv4 (default Hibernate implementation for UUID ID generator):
```shell
run-uuid-insert
```

Test with UUIDv7 (just create a UUID7 at object creation time):
```shell
run-uuid7insert
```

Test with UUIDv7 (with sequence creator annotation):
```shell
run-uuid7auto-insert
```

## Results

```
shell:>run-int-insert
Created 1000000 INT entries in 380.661541ms ms
Inserted 1000000 entries with INT in 12619 ms
Total time INT Insert: 13004 ms

shell:>run-uuid-insert
Created 1000000 UUID entries in 59.922125ms ms
Inserted 1000000 entries with UUID in 14371 ms
Total time UUID Insert: 14432 ms

shell:>run-uuid7insert
Created 1000000 UUID7 entries in 496.876833ms ms
Inserted 1000000 entries with UUID7 in 129546 ms
Total time UUID7 Insert: 130043 ms

shell:>run-uuid7auto-insert
Created 1000000 UUID7 Auto entries in 63.345166ms ms
Inserted 1000000 entries with UUID7 Auto in 13038 ms
Total time UUID7 Auto Insert: 13101 ms
```
