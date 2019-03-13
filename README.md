# TaxService

Clone project from git by using following url

############    https://github.com/bhushandesh315/EventManagment.git   ##################



1)Enviornment Setup required JDK 1.8 and Maven to run application



############    follow below steps in sequence    ##############




2) Start application by running TaxServiceApplication.java


3) After starting application hit below url by passing input as given below through postman .

url :  http://localhost:8281/taxService/invoice


Input :


[
    {
        "amount": 300,
        "category": "B"
    },
    {
        "amount": 200,
        "category": "A"
    },
    {
        "amount": 400,
        "category": "C"
    },
     {
        "amount": 1400,
        "category": "A"
    }
]

  
On basis of above input we get taxable amount and sum of toatal amount depend on the basis of category A B and C.
You can increase as many as input as these are the items which are scanned and come as input to machine.


for above input output should be

For Category :B percentage of tax applied :20% Total Amount by applying tax on 300 is 360
For Category :A percentage of tax applied :10% Total Amount by applying tax on 200 is 220
For Category :C percentage of tax applied :0% Total Amount by applying tax on 400 is 400
For Category :A percentage of tax applied :10% Total Amount by applying tax on 1400 is 1540
Total Bill Amount is :: 2520

4) Junit Testing run
  
   TaxServiceApplicationTest.java

6) For git hub link find below link

git hub link : https://github.com/bhushandesh315/EventManagment/tree/master/EventManagmentSystem



