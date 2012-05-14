create unique index IX_BF52271A on OAuthApplication (consumerKey);
create unique index IX_AA24E954 on OAuthApplication (consumerKey, consumerSecret);
create index IX_5583043E on OAuthApplication (name);
create index IX_D41BBDFF on OAuthApplication (ownerId);
create index IX_C517DC2C on OAuthApplication (website);

create unique index IX_F9E482BC on OAuthApplications_Users (accessToken);
create unique index IX_8C274BE4 on OAuthApplications_Users (accessToken, accessSecret);
create unique index IX_C75B21CC on OAuthApplications_Users (applicationId, userId);