INSERT INTO Question(categoryID, title, description, explanationText, forceCorrectCount, isCaseSensitive, questionType, "position")
VALUES (:e.categoryID, :e.title, :e.text, :e.explanationText, :forceCorrectCount, :isCaseSensitive, :questionType, :e.position)