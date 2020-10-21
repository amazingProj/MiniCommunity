fun main(){
    val bob: Married = Married("33333333",_gender= true,_address = "New York, 12 ,11",
            _birthday = "1/22/2001",_Torah = 33, _attempts = 3,_payment = 15000f,_work = 100,_str ="spirit",
            _ids = "44444444",_numberOfChildrenU18 = 5  )
    val Julia: Married = Married("33333333",_gender= true,_address = "New York, 12 ,15",
            _birthday = "1/22/2001",_Torah =40, _attempts = 3,_payment = 15000f,_work = 100, _str = "spirit",
            _ids = "555555555",_numberOfChildrenU18 = 2)
    val Kate: Unmarried = Unmarried("111111111",_gender= true,_address = "Abu Dabi, 12 ,17",
            _birthday = "1/22/2001",_Torah = 50, _attempts = 3,_payment = 15000f,_work = 100,_str ="musician",
            _numberYearsOfStudying = 12)
    val chiefRabi : Married = Married(id="1111111",_gender = true,_address = "New York"
            ,_birthday = "1/2/2001",_Torah = 100 ,_work = 1 , _str ="spirit",_payment =7000f
            ,_attempts = 100,_ids="11111111",_numberOfChildrenU18 = 10)
    if (bob.friendship == 1)
        println("bob has to pay " + bob.charge() + " bob can get maximum: " + bob.deserve_money() + " money " +
            " bob recommended voluntering time " +bob.volunteer())
    if (Julia.friendship == 1)
        println("julia has to pay " + Julia.charge() + " julia can get maximum: " + Julia.deserve_money() + " money " +
                " bob recommended voluntering time "  +Julia.volunteer())
    if (Kate.friendship == 1)
        println("kate have to pay " + Kate.charge() + " kate can get maximum: " + Kate.deserve_money() + " money " +
                " kate recommended voluntering time " +Kate.volunteer())
    if (chiefRabi.friendship == 1)
        println("Rabbi have to pay " + chiefRabi.charge() + " taxes " + " Rabbi can get maximum: " + chiefRabi.deserve_money() + " money " +
                " Rabbi recommended voluntering time " +chiefRabi.volunteer())

}
/* status = is working
result input:



 */