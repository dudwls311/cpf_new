DROP TABLE  IF EXISTS [TABLE_NAME];

/**********************************/
/* Table Name: [Description] */
/**********************************/
CREATE TABLE [TABLE_NAME](
[DDL_COLUMN]
	ISDEL	 	VARCHAR(1)	DEFAULT	'Y'		NOT NULL	,
	CREATED	 	DATETIME	DEFAULT	NOW()				,
	CREATED_ID	VARCHAR(20)								,
	MODIFIED	DATETIME	DEFAULT	NOW()				,
	MODIFIED_ID	VARCHAR(20)								
);
ALTER TABLE [TABLE_NAME] ADD CONSTRAINT IDX_[TABLE_NAME]_PK PRIMARY KEY ([FirstColumn]);

-- DELETE FROM JNITSEQ WHERE TABLE_NAME = '[IDGEN_TABLE_NAME]';
INSERT INTO JNITSEQ(TABLE_NAME, NEXT_ID) VALUES ('[IDGEN_TABLE_NAME]', '1');