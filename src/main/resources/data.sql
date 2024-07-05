INSERT INTO "user" (password)
SELECT '1234fgggh**'
WHERE NOT EXISTS (SELECT 1 FROM "user" WHERE password = '1234fgggh**');

