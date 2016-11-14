CREATE TABLE Admins(
	AdminId char(10)NOT NULL,
	Password varchar(30)NOT NULL,
	AdminName varchar(30)NOT NULL,
	CONSTRAINT key_Admins PRIMARY KEY (AdminId)
);

CREATE TABLE Users(
	UserId char(10)NOT NULL,
	Password varchar(30)NOT NULL,
	UserName varchar(30)NOT NULL,
	BirthDay date,
	Class varchar(30),
	CONSTRAINT key_Users PRIMARY KEY (UserId)
);

CREATE TABLE Subjects(
	SubjectId char(10)NOT NULL,
	SubjectName varchar(30)NOT NULL,
	CONSTRAINT key_Subjects PRIMARY KEY (SubjectId)
);

CREATE TABLE Chaps(
	SubjectId char(10)NOT NULL,
	Chapter int NOT NULL,
	ChapterName varchar(30)NOT NULL,
	CONSTRAINT key_Chaps PRIMARY KEY (SubjectId,Chapter),
	CONSTRAINT key_2Subjects FOREIGN KEY (SubjectId) REFERENCES Subjects(SubjectId)
);

CREATE TABLE Questions(
	QuestionId char(10)NOT NULL,
	Question varchar(1000)NOT NULL,
	Levels varchar(10)NOT NULL,
	SubjectId char(10)NOT NULL,
	Chapter int NOT NULL,
	CONSTRAINT key_Questions PRIMARY KEY (QuestionId),
	CONSTRAINT key_2Chaps FOREIGN KEY (SubjectId,Chapter) REFERENCES Chaps(SubjectId,Chapter)
);

CREATE TABLE Answers(
	QuestionId char(10)NOT NULL,
	Answer varchar(1000)NOT NULL,
	YesNo varchar(10)NOT NULL,
	Number int NOT NULL,
	CONSTRAINT key_answers PRIMARY KEY(QuestionId, number),
	CONSTRAINT key_2Question FOREIGN KEY (QuestionId) REFERENCES Questions(QuestionId)
);

CREATE TABLE Results(
	UserId char(10)NOT NULL,
	TestDay date NOT NULL,
	SubjectId char(10)NOT NULL,
	Result float(2)NOT NULL,
	CONSTRAINT key_Results PRIMARY KEY (UserId,TestDay,SubjectId),
	CONSTRAINT key_2Users FOREIGN KEY (UserId) REFERENCES Users(UserId),
	CONSTRAINT key_3Subjects FOREIGN KEY (SubjectId) REFERENCES Subjects(SubjectId)
);

CREATE TABLE Tests(
	TestId char(10)NOT NULL,
	SubjectId char(10)NOT NULL,
	TestDay date NOT NULL,
	AdminId char(10)NOT NULL,
	QuestionId char(10)NOT NULL,
	CONSTRAINT key_Tests PRIMARY KEY (TestId),
	CONSTRAINT key_4Subjects FOREIGN KEY (SubjectId) REFERENCES Subjects(SubjectId),
	CONSTRAINT key_2Admins FOREIGN KEY (AdminId) REFERENCES Admins(AdminId),
	CONSTRAINT key_3Questions FOREIGN KEY (QuestionId) REFERENCES Questions(QuestionId)
);

create table exams (examId serial NOT NULL PRIMARY KEY  , 
	subjectId character(10) NOT NULL, 
	time INT NOT NULL, 
	examCode character varying(30) NOT NULL);
	
CREATE TABLE examElem(examElemId serial NOT NULL PRIMARY KEY, 
	examId INT NOT NULL, questionId char(10) NOT NULL);

ALTER TABLE exams ADD CONSTRAINT fk_subject FOREIGN KEY (subjectId) REFERENCES subjects(subjectid);
ALTER TABLE examElem ADD CONSTRAINT fk_exam FOREIGN KEY (examId) REFERENCES exams(examId);
ALTER TABLE examElem ADD CONSTRAINT fk_question FOREIGN KEY (questionId) REFERENCES questions(questionId);