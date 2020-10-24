/**
 * class Married extends community_member
 * @property pID - wife/husband 's id
 * @property numberOfChildrenU18 - for having under 18 children community collect money to parents
 * for promoting the children of the community
 * @see Unmarried
 * @constructor construct married member
 */
class Married: CommunityMember {

    /******************* properties ************/
    /**
     * partner's id
     * private set
     * Getting value by the public one
     */
    private var pID: String="" //id of the partner
        get() = field
        set(v){if(v.length == 9)field=v}

    /**
     * private set
     * Getting value by the public one
     */
     var numberOfChildrenU18: Int =0 //number of children under 1
        get() = field
        set(v){if(v > 0) field = v}


    /**************** c'ctor ****************************/
    /**
     * construct married class
     * @see CommunityMember c'ctor
     * @param _ids - id second that given: of partner
     * @param _numberOfChildrenU18 - number of children under 18
     */
    constructor(id: String, _friendship: Int =0, _gender: Boolean, _address: String, _birthday: String,
                _Torah: Int , _work: Int , _str: String, _payment: Float , _attempts: Int ,
                _ids:String , _numberOfChildrenU18 : Int):super(id, _friendship, _gender, _address, _birthday,
            _Torah, _work, _str, _payment, _attempts){
        pID=_ids; numberOfChildrenU18 = _numberOfChildrenU18;
    }

/*********************** functions *********************/
    /**
    * maximum money this member could get from Gemach
     * married community member will pay taxes by the rules
     * assume var = payment/numberOfChild
     * Notice: Talmid Chacham automatically does not have taxes to pay
     * case num. 1: var is bigger than 5000 and under 10000 -> 25 % taxes
     * case two: var is bigger than 10000 -> 50 % taxes
     *
     * @return how much taxes' money to pay to community
     *
     */
    override fun charge():Float {
        var payment:Float = this.payment
        var perchild: Float = payment / this.numberOfChildrenU18

        when (perchild.toInt()) {
            in 0..5000 -> return 0f
            in 5001..10000 -> return (25* payment)/100
        }

        return (50* payment)/100
    }

    /**
     * maximum money this specific married member can get from Gemach
     * @return amount of money
     */
    override fun desrveMoneyfromGemach(): Float {
        var payperchild: Float = this.payment / numberOfChildrenU18
        if (payperchild < 2000) {
            payperchild = 2000 - payperchild
        } else {
            payperchild = 0f
        }
        return (numberOfChildrenU18 * (500 + payperchild) + 1000).toFloat()
    }

    /**
     * number of children under 18 called U18
     * U18 is 1 or less -> 30% of free time
     * U18 is 2-4 -> 15 % of free time
     * U18 is 5 or more -> 1% of free time
     * @return number of hours that fits to the member
     */
    override fun recommendedVolunteerHours(): Int {
        var freeTime: Int = 18 * 6 - this.works
        val fraction: (Float) -> Float = { a:Float -> a * freeTime.toFloat() }

        when(numberOfChildrenU18){
            in 0..1 -> return fraction(0.3f).toInt()
            in 2..4 ->  return fraction(0.15f).toInt()
        }
       return fraction(0.01f).toInt() // other cases
    }

    override fun toString(): String {
        return super.toString()+  "Married status  " +
                "    "+"    Recommended volunteer hours : ${recommendedVolunteerHours()}"
    }
}