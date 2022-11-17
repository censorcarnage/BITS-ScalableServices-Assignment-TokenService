CREATE TABLE IF NOT EXISTS range_central (
  rangeid INT NOT NULL,
  lower BIGINT NOT NULL,
  higher BIGINT NOT NULL,
  node varchar(200),
  created TIMESTAMP,
  expired INT NOT NULL,
  used INT NOT NULL,
  PRIMARY KEY (rangeid)
);