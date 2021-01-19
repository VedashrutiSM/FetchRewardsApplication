# FetchRewardsApplication
1. In terminal, under your project directory and run ``./mvnw spring-boot:run`` to build <br>
2. Test addPoints endpoint on Postman: http://localhost:5000/addPoints
In body please give input in json
Ex 1:
{
    "payerName":"DANNON",
    "points":300,
    "transactionDate":"10/31 10AM"
}

Ex 2:
{
    "payerName":"UNILEVER",
    "points":200,
    "transactionDate":"10/31 11AM"
}
I am assuming that 2nd transaction date is greater than 1st transaction date and 3rd transaction date is greater than 2nd transaction date and so on.

3. Test deduction functionality from the endpoint on postman : http://localhost:5000/deductPoints

4. To check the remaining points test the endpoint on postman : http://localhost:5000/getPoints

###Cloud - AWS( Available till Jan 22, 2021)

1. Check the link http://fetchrewardsapp-env.eba-7dbnfmsz.us-east-2.elasticbeanstalk.com/hello-world to check if the server is up.
   (You will see "Hello world from Vedashruti" if the server is up)
2. Test addPoints endpoint on Postman: http://fetchrewardsapp-env.eba-7dbnfmsz.us-east-2.elasticbeanstalk.com/addPoints
3. Test deduction functionality from the endpoint on postman : http://fetchrewardsapp-env.eba-7dbnfmsz.us-east-2.elasticbeanstalk.com/deductPoints
4. To check the remaining points test the endpoint on postman : http://fetchrewardsapp-env.eba-7dbnfmsz.us-east-2.elasticbeanstalk.com/getPoints


