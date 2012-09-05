create table OAuthApplication (
	applicationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	website VARCHAR(75) null,
	callBackURL VARCHAR(75) null,
	accessLevel INTEGER,
	consumerKey VARCHAR(75) null,
	consumerSecret VARCHAR(75) null
);

create table OAuthApplicationUser (
	oaauId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	applicationId LONG,
	accessToken VARCHAR(75) null,
	accessSecret VARCHAR(75) null,
	authorized BOOLEAN
);