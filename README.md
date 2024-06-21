# BudgetApp
The Budget App is a Java web application designed to facilitate personal finance management. Developed using Spring Boot and PostgreSQL, the app enables users to effortlessly track income and expenses, offering detailed monthly breakdowns and aggregated summaries for moths, quarters, half-years, and years. 

API:

api/budget/addUsers-to add list of users to the database

api/budget/getUsers-to retrieve users information

api/income/addIncome-to add income details of a person with their user id as RequestParam

api/income/getTransactions/{userId}-to retrieve all income transactions of a user

api/income/monthly-to get user's income details monthwise in total by giving user id as RequestParam

api/income/quarterly-to get user's income details for three months in total by giving user id as RequestParam

api/income/halfyearly-to get user's income details for six months in total by giving user id as RequestParam

api/income/yearly-to get user's income details for a year in total by giving user id as RequestParam

api/expenses/addExpense-to add expense details of a person with their user id as RequestParam

api/expenses/getTransactions/{userId}-to retrieve all expense transactions of a user

api/expenses/monthly-to get user's expense details monthwise in total by giving user id as RequestParam

api/expenses/quarterly-to get user's expense details for three months in total by giving user id as RequestParam

api/expenses/halfyearly-to get user's expense details for six months in total by giving user id as RequestParam

api/expenses/yearly-to get user's expense details for a year in total by giving user id as RequestParam


