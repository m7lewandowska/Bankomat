fun main(args: Array<String>)
{
    println("___________________CASH MASCHINE________________________")

    val ATM = Bankomat()
    val client = Klient()
    var acc_code = client.account_code
    var isPinCorrect = false
    while(isPinCorrect == false)
    {
        print("\nPlease enter your account code: ")
        val code_check = readLine()

        if (acc_code == code_check)
        {
            isPinCorrect = true
            println("--------------------------------------------")
            println(" You are logged as: " + client.client_name + " " + client.clien_surname + " \n Account Code: **** \n Account State: " + client.account_state)
            println("--------------------------------------------")
            print("How many cash do you want to take out: ")
            val cash_input = readLine()!!
            // converts the string input to integer
            var cash_to_out: Int = cash_input.trim().toInt()
            println("Please wait for confirmation....")

            ATM.TakeOut(cash_to_out, client)

            println("All done for today :)")
            println("_____________________________________________________")
        }
        else
        {
            println("Wrong account code! Please try again")
            isPinCorrect = false
        }
    }
}