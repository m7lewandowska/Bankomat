var isornot:Boolean = true
var banknot_10:Int = 2
var banknot_50:Int = 1
var banknot_100:Int = 1
var banknot_200:Int = 1
var banknot_500:Int = 2
var validater = 1

fun check(banknot:Int, cashout:Int, banknot_10:Int, banknot_50:Int, banknot_100:Int, banknot_200:Int, banknot_500:Int)
{
    var banknot2_10:Int = banknot_10
    var banknot2_50:Int = banknot_50
    var banknot2_100:Int = banknot_100
    var banknot2_200:Int = banknot_200
    var banknot2_500:Int = banknot_500

    var cashouttmp = cashout
    var banknottmp = banknot

    if(banknot == 500) {
        validater = cashouttmp / 500
        if(banknot2_500 < validater ) {
            isornot = false
            return;
        }
        else {
            while (cashouttmp >= 500 && banknot2_500 > 0 && isornot == true) {
                banknot2_500 -= 1
                cashouttmp -= 500
            }
            check(200, cashouttmp, banknot_10, banknot_50, banknot_100, banknot_200, banknot_500)
        }
    }

    if(banknot == 200) {
        validater = cashouttmp / 200
        if(banknot2_200 < validater ) {
            isornot = false
            return;
        }
        else {
            while (cashouttmp >= 200 && banknot2_200 > 0 && isornot == true) {
                banknot2_200 -= 1
                cashouttmp -= 200
            }
            check(100, cashouttmp, banknot_10, banknot_50, banknot_100, banknot_200, banknot_500)
        }
    }

    if(banknot == 100) {
        validater = cashouttmp / 100
        if(banknot2_100 < validater ) {
            isornot = false
            return;
        }
        else {
            while (cashouttmp >= 100 && banknot2_100 > 0 && isornot == true) {
                banknot2_100 -= 1
                cashouttmp -= 100
            }
            check(50, cashouttmp, banknot_10, banknot_50, banknot_100, banknot_200, banknot_500)
        }
    }

   if(banknot == 50) {
       validater = cashouttmp / 50
       if(banknot2_50 < validater ) {
           isornot = false
           return;
       }
       else {
           while (cashouttmp >= 50 && banknot2_50 > 0 && isornot == true) {
               banknot2_50 -= 1
               cashouttmp -= 50
           }
           check(10, cashouttmp, banknot_10, banknot_50, banknot_100, banknot_200, banknot_500)
       }
   }

    if(banknot == 10) {
        validater = cashouttmp / 10
        if(banknot2_10 < validater ) {
            isornot = false
            return;
        }
        /*while (cashouttmp >= 10 ||banknot2_10 >= 0 && isornot == true) {
            if (banknot2_10 <= 0) {
                isornot = false
                return
            }
            banknot2_10 -= 1
            cashouttmp -= 10
        }*/
    }
}

class Bankomat()
{
   /* var banknot_10:Int = 2 // 300 PLN
    var banknot_50:Int = 1 // 1 000 PLN
    var banknot_100:Int = 10 // 1 000 PLN
    var banknot_200:Int = 10 // 2 000 PLN
    var banknot_500:Int = 5 // 2 500 PLN*/

    //All Money in ATM = 6 800 PLN
    var all_money_in_ATM = ((banknot_10 * 10) + (banknot_50 * 50) + (banknot_100 * 100) + (banknot_200 * 200) + (banknot_500 * 500)).toInt()

    fun TakeOut(cash_to_out_tmp: Int, client: Klient)
    {
        var cash_out = cash_to_out_tmp

        if(client.account_state.toInt() - cash_out < 0 || client.account_state.toInt() - cash_out < 0)
        {
            println("You don't have enought money on your account!!!")
            return
        }

        else if (cash_out % 10 != 0)
        {
            println("Wrong number!!!")
            return
        }

        println("CURRENT STATE OF ATM: " + all_money_in_ATM + " PLN")

        check(500, cash_out, banknot_10, banknot_50,banknot_100,banknot_200,banknot_500)

        if(isornot == true) {
            while (cash_out >= 500 && banknot_500 > 0) {
                banknot_500 -= 1
                println("Cash taken out: 500 PLN")
                cash_out -= 500
            }

            while (cash_out >= 200 && banknot_200 > 0) {
                banknot_200 -= 1
                println("Cash taken out: 200 PLN")
                cash_out -= 200
            }

            while (cash_out >= 100 && banknot_100 > 0) {
                banknot_100 -= 1
                println("Cash taken out: 100 PLN")
                cash_out -= 100
            }

            while (cash_out >= 50 && banknot_50 > 0) {
                banknot_50 -= 1
                println("Cash taken out: 50 PLN")
                cash_out -= 50
            }

            while (cash_out >= 10 && banknot_10 > 0)
            {
                banknot_10 -= 1
                println("Cash taken out: 10 PLN")
                cash_out -= 10
            }
        }

        else if (isornot == false)
        {
            println("We can not provide your withdraw");
            return;
        }

        client.account_state -= cash_out
        all_money_in_ATM -= cash_to_out_tmp

        println(client.client_name +" "+ client.clien_surname + " took out: " + cash_to_out_tmp + " PLN " +"\nCurrent amount of money in cash mashine: " + all_money_in_ATM + " PLN")
    }
}