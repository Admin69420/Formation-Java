/* 3.1	Pour l�employ� num�ro 21 de la table HumanResources.Employee, examinez sa date d�arriv�e dans l�entreprise
		ainsi que sa date de naissance. Si son anciennet� est de plus de 9 ans, afficher la phrase � L�employ� 21 est un Senior �.
		Sinon, il faudra signaler qu�il s�agit d�un Junior.
*/

USE AdventureWorks2008R2
GO

DECLARE @date_arrivee DATE, @date_naiss DATE

SELECT @date_arrivee = HireDate , @date_naiss = BirthDate
  FROM HumanResources.Employee
 WHERE BusinessEntityID = 21

IF ( DATEDIFF( YEAR, @date_arrivee, GETDATE () ) > 9 )
  BEGIN
	PRINT 'L�employ� 21 est un Senior'
  END
ELSE
  BEGIN
	PRINT 'L�employ� 21 est un Junior'
  END

----------------------------------------------------------------------------------------------

/* 3.2	S�il existe dans la table Person.Person, quelqu�un du nom de � Zugelder �, affichez son nom complet (Pr�nom, deuxi�me nom, nom de famille)
		Sinon, signaler qu�il n�existe personne portant ce nom !
*/

USE AdventureWorks2008R2
GO

DECLARE @prenom_Zug nvarchar(50), @deux_prenom_Zug nvarchar(50), @nom_Zug nvarchar(50)

IF EXISTS (SELECT * FROM Person.Person WHERE LastName LIKE 'Zugelder')
  BEGIN
    SELECT @prenom_Zug = FirstName, @deux_prenom_Zug = MiddleName, @nom_Zug = LastName
      FROM Person.Person
     WHERE LastName LIKE 'Zugelder'
    
    PRINT (@prenom_Zug + ' ' + @deux_prenom_Zug + ' ' + @nom_Zug )
  END
ELSE
  BEGIN
	PRINT 'Personne ne s�appelle Zugelder dans la table...'
  END

----------------------------------------------------------------------------------------------

/* 3.3	Si le nombre de femmes est plus important que le nombre d�hommes, affichez, dans une table, � Les femmes domineront le monde ! �
		Sinon, indiquez � La guerre des sexes n�est pas finie� �
		Afficher le contenu de votre table
*/

USE AdventureWorks2008R2
GO

IF ( (SELECT COUNT(*) FROM HumanResources.Employee WHERE Gender LIKE 'F') > (SELECT COUNT(*) FROM HumanResources.Employee WHERE Gender LIKE 'M') )
  BEGIN
	SELECT 'Les femmes domineront le monde !' AS 'Avenir du monde' INTO #temp_monde
	SELECT * FROM #temp_monde
	DROP TABLE #temp_monde
  END
ELSE
  BEGIN
    SELECT 'La guerre des sexes n�est pas finie�' AS 'Avenir du monde' INTO #temp_monde2
    SELECT * FROM #temp_monde2
    DROP TABLE #temp_monde2
  END

----------------------------------------------------------------------------------------------

/* 3.4	Comparer le nombre d�heures d�absence des employ�s 21 et 27. Si le nombre d�heures de repos de l�un
		ET son nombre d�heures de vacances sont plus importants que ceux de l�autre, signalez-le par un message � l��cran !
		Sinon, si le nombre d�heures de repos de l�un est plus grand que celui de l�autre,
		mais que son nombre d�heures de vacances est inf�rieur, signaler que tout va bien.
		Dans les autres cas, il n�y a rien � signaler.
		Choisissez vous-m�me du quel employ� vous partirez pour faire la comparaison.
*/

USE AdventureWorks2008R2
GO

IF ( ((SELECT SickLeaveHours FROM HumanResources.Employee WHERE BusinessEntityID = 21)
	  > (SELECT SickLeaveHours FROM HumanResources.Employee WHERE BusinessEntityID = 27))
	  AND ( (SELECT VacationHours FROM HumanResources.Employee WHERE BusinessEntityID = 21)
		     > (SELECT VacationHours FROM HumanResources.Employee WHERE BusinessEntityID = 27)) )
  BEGIN
    PRINT ('21 a bien plus profit� de la vie que 27 !')
  END
ELSE
  BEGIN
    IF ( ((SELECT SickLeaveHours FROM HumanResources.Employee WHERE BusinessEntityID = 21)
	      > (SELECT SickLeaveHours FROM HumanResources.Employee WHERE BusinessEntityID = 27))
	      AND ( (SELECT VacationHours FROM HumanResources.Employee WHERE BusinessEntityID = 21)
		         < (SELECT VacationHours FROM HumanResources.Employee WHERE BusinessEntityID = 27)))
	  BEGIN
	    PRINT ('21 a une petite sant�, mais tout va bien !')
	  END
	ELSE
	  BEGIN
	    PRINT ('27 est un paresseux !')
	  END
  END

----------------------------------------------------------------------------------------------

/* 3.5	Afficher, dans une table temporaire dont le nom de la colonne sera � Suivi_employ� � le statut d�un employ� analys�.
		Selon le cas, si l�employ� est n� apr�s l�an 2000, cela est vraisemblablement impossible.
		Dans le cas o� l�employ� est arriv� dans l�entreprise entre 1995 et 2005, il est un Junior.
		Entre 1990 et 1994 il est un Qualified. Entre 1985 et 1989, il est Confirmed, sinon, c�est un Vice President !
		Traitez un employ� au hasard, de la table HumanResources.Employee.
		Un select vers votre table temporaire suffit !
*/

USE AdventureWorks2008R2
GO

-- Nous choisissons M. Frank Lee, BusinessEntityID 200

CREATE TABLE #temp_suivi (Suivi_employ� VARCHAR(50))

DECLARE @annee_naiss INTEGER, @date_arrivee INTEGER

SELECT @annee_naiss = YEAR(BirthDate), @date_arrivee = YEAR(HireDate)
  FROM HumanResources.Employee
 WHERE BusinessEntityID = 200

IF ( @annee_naiss > 2000 )
  BEGIN
    INSERT INTO #temp_suivi VALUES ('Impossible')
  END
ELSE
  BEGIN
    IF ( (@date_arrivee >= 1995) AND (@date_arrivee <= 2005) )
      BEGIN
        INSERT INTO #temp_suivi VALUES ('Junior')
      END
    ELSE
      BEGIN
		IF ( (@date_arrivee >= 1990) AND (@date_arrivee <= 1994) )
		  BEGIN
		    INSERT INTO #temp_suivi VALUES ('Qualified')
		  END
		ELSE
		  BEGIN
		    IF ( (@date_arrivee >= 1985) AND (@date_arrivee <= 1989) )
		      BEGIN
		        INSERT INTO #temp_suivi VALUES ('Confirmed')
		      END
		    ELSE
		      BEGIN
		        INSERT INTO #temp_suivi VALUES ('Vice President')
		      END
		  END
	  END
  END

SELECT * FROM #temp_suivi

DROP TABLE #temp_suivi

----------------------------------------------------------------------------------------------

/* 3.6	En fonction de l��ge de l�employ� trait�, pr�venez-nous s�il sera bient�t � la retraite ou pas
		via une phrase affich�e � l��cran � Attention, retraite imminente pour [nom_employ�] ! � ou justement,
		� [nom_employ�] a encore de longue ann�es � faire chez nous ! �
		Utilisez ici un CASE pour afficher la phrase voulue.
*/

USE AdventureWorks2008R2
GO

-- Nous choisissons M. Frank Lee, BusinessEntityID 200

DECLARE @age INTEGER, @nom nvarchar(50), @affichage varchar(100)

SELECT @nom = LastName FROM Person.Person WHERE BusinessEntityID = 200

SELECT @affichage = CASE WHEN YEAR (BirthDate) > ( YEAR ( GETDATE () ) - 55 ) THEN 'Attention, retraite imminente pour ' + @nom + ' !'
						 ELSE @nom + ' a encore de longue ann�es � faire chez nous !'
					END
  FROM HumanResources.Employee

PRINT ( @affichage )

----------------------------------------------------------------------------------------------

/* 3.7	Enregistrez dans une variable de type TABLE, le nombre d�occurrence des noms Coleman, Powell, Suarez et Vance.
		Vous trouverez ces noms dans la table Person.Person.
		Il est possible de faire l�op�ration en une seule requ�te, cependant faites le �galement en cr�ant pour chaque �l�ment � transf�rer,
		une variable suppl�mentaire.
*/

USE AdventureWorks2008R2
GO

DECLARE @tab_nbre_noms TABLE (nom nvarchar(50), nbre_occurence int)

INSERT INTO @tab_nbre_noms SELECT LastName, COUNT(*)
							 FROM Person.Person
						    WHERE LastName LIKE 'Coleman' OR LastName LIKE 'Powell' OR LastName LIKE 'Suarez' OR LastName LIKE 'Vance'
						 GROUP BY LastName

SELECT * FROM @tab_nbre_noms

-- OU BIEN

DECLARE @tab_nbre_noms2 TABLE (nom nvarchar(50), nbre_occurence int)
DECLARE @nbre_Coleman INTEGER, @nbre_Powell INTEGER, @nbre_Suarez INTEGER, @nbre_Vance INTEGER

SELECT @nbre_Coleman = COUNT(*) FROM Person.Person WHERE LastName LIKE 'Coleman'
SELECT @nbre_Powell = COUNT(*) FROM Person.Person WHERE LastName LIKE 'Powell'
SELECT @nbre_Suarez = COUNT(*) FROM Person.Person WHERE LastName LIKE 'Suarez'
SELECT @nbre_Vance = COUNT(*) FROM Person.Person WHERE LastName LIKE 'Vance'

INSERT INTO @tab_nbre_noms2 VALUES ('Coleman', @nbre_Coleman)
INSERT INTO @tab_nbre_noms2 VALUES ('Powell', @nbre_Powell)
INSERT INTO @tab_nbre_noms2 VALUES ('Suarez', @nbre_Suarez)
INSERT INTO @tab_nbre_noms2 VALUES ('Vance', @nbre_Vance)

SELECT * FROM @tab_nbre_noms2

----------------------------------------------------------------------------------------------

/* 3.8	S�il existe plus de 20 employ�s n�s avant 1975, alors dans le cas o� ils ont plus de 80 heures d�absence totale (vacances et maladie),
		afficher dans une table temporaire, qu�ils sont en exc�dant. Dans le cas o� ce nombre est entre 60 et 80,
		ils sont dans la norme, dans le cas o� ils sont entre 40 et 60 heures d�absence, alors ils sont de bons �l�ments !
		Faites l�exercice �galement s�il existe plus de 20 employ�s n�s entre 1980 et 1990.
*/

USE AdventureWorks2008R2
GO

CREATE TABLE #temp_absences (ID_Emp INTEGER, Annee INTEGER, Statut varchar(20))

IF ( ((SELECT COUNT(*) FROM HumanResources.Employee WHERE YEAR (BirthDate) < 1975) > 20)
     OR ((SELECT COUNT(*) FROM HumanResources.Employee WHERE YEAR (BirthDate) BETWEEN 1980 AND 1990) > 20) )
  BEGIN
    INSERT INTO #temp_absences
         SELECT BusinessEntityID, YEAR (BirthDate), 
				CASE
					WHEN (VacationHours + SickLeaveHours) > 79 THEN 'Exc�dant'
					WHEN (VacationHours + SickLeaveHours) BETWEEN 60 AND 79 THEN 'Dans la norme'
					WHEN (VacationHours + SickLeaveHours) BETWEEN 40 AND 59 THEN 'Bon �l�ment'
					ELSE 'N / A'
				END
		   FROM HumanResources.Employee
		  WHERE (YEAR (BirthDate) < 1975) OR (YEAR (BirthDate) BETWEEN 1980 AND 1990)
  END

SELECT * FROM #temp_absences
DROP TABLE #temp_absences
