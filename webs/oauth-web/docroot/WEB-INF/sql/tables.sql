create table OAuthApplication (
	id_ LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ownerId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	website VARCHAR(75) null,
	secret VARCHAR(75) null,
	callBackURL VARCHAR(75) null
);