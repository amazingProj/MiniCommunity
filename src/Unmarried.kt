/**
 * class represents unmarried member class
 * @constructor construct an unmarried member
 * @property numberYearsOfStudying - affects on the number of recommended volunteering time.
 *
 */
class Unmarried : Community_member {
    /**
     * represents the number of member's years of studying
     * private set
     * Getting the var from the public variable
     */
    private var _numberYearsOfStudying:Int = 0
        private set
    public var numberYearsOfStudying
        get()=_numberYearsOfStudying

    /**
     * Construct Unmarried class
     * for fully examine constructor please look at Community_member's constructor
     * @see Community_member
     * @param _numberYearsOfStudying - unmarried property
     *
     */
    constructor(id:String, _friendship: Int =0 , _gender: Boolean, _address: String, _birthday: String,
                _Torah: Int = 0, _work: Int = 0, _str: String, _payment: Float = 0f, _attempts: Int = 0,
    _numberYearsOfStudying:Int):super(id,_friendship,_gender,_address,_birthday,_Torah
    ,_work,_str,_payment,_attempts){ numberYearsOfStudying = _numberYearsOfStudying}

    /**
     * unmarried community member will pay taxes by the rules
     * payment under 5000 no taxes to pay
     * payment above 5000 and under 10000 -> 10% taxes
     * payment above 10000 and 25000 -> 30 % taxes
     * payment above 25000 -> 50 % taxes
     * Talmid Chacham has no taxes to pay
     * @return how much taxes' money to pay to community
     * @see Married.charge
     *
     *
     */
    override fun charge():Float {
        if (!((this.works == 0) and (this.Torah > 52) and (this.gender)))
        {
            var money:Float = this.payment
            if (money < 5000f)
                return 0f
            else if(money<10000f)
                return 0.1f * money
                 else{
                if (money < 25000f)
                    return 0.3f * money
                else
                    return 0.5f * money
            }
        }
        return 0f //For Talmid Chacham
    }

    /**
     * get the member know that unmarried does not recieve money
     * from Gemach
     * @return 0 money
     */
    override fun deserve_money(): Float {
        println("Unmarried do not deserve any money")
        return 0f
    }
    /**
     * for unmarried community member
     * takes 45% of free time for volunteering
     * if number of study is 12 or above 65%
     * @return offered volunteering tim for this member
     */
    override fun volunteer() : Int{
        val freeTime = { a:Int,b:Int -> 6*18 - a - b }
        val time = freeTime(this.works,this.Torah)
        if(numberYearsOfStudying >= 12)
            return (0.6 * time).toInt()
        return (0.45 * time).toInt()
    }
}