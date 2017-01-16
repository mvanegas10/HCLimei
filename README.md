# HCLimei
Software to follow-up patient histories in acupunture.
## Getting Started

Entire implementation developed in Java. See deployment for notes on how to deploy the project on a live system.

Create databame **hclimei** with *UTF8*:
```sql
CREATE DATABASE hclimei CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```
Import data from source
```sql
USE hclimei;
SET autocommit=0 ; source <dir to source file> ; COMMIT ;
```
## Built With

* Java
* IntelliJ IDEA

## Author
<!-- Contributors table START -->
| [![Meili Vanegas](https://avatars.githubusercontent.com/mvanegas10?s=100)<br /><sub>Meili Vanegas</sub>](https://github.com/mvanegas10)<br /> |
| :---: |

<!-- Contributors table END -->
