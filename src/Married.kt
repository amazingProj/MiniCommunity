/**
 * class Married extends community_member
 * @property ids - wife/husband 's id
 * @property numberOfChildrenU18 - for having under 18 children community collect money to parents
 * for promoting the children of the community
 * @see Unmarried
 * @constructor construct married member
 */
class Married: Community_member {
    /**
     * partner's id
     * private set
     * Getting value by the public one
     */
    private var ids_: String="" //id of the second part of the
        private set
    public var ids: String
        set(value) {ids_ = value}
        get() = id

    /**
     * private set
     * Getting value by the public one
     */
    private var _numberOfChildrenU18: Int =0 //number of children under 1
        private set
    public var numberOfChildrenU18
        get() = _numberOfChildrenU18

    /**
     * construct married class
     * @see Community_member c'ctor
     * @param _ids - partner's id
     * @param _numberOfChildrenU18 - number of children under 18
     */
    constructor(id: String, _friendship: Int =0, _gender: Boolean, _address: String, _birthday: String,
                _Torah: Int = 0, _work: Int = 0, _str: String, _payment: Float = 0f, _attempts: Int = 0,
                _ids:String , _numberOfChildrenU18 : Int):super(id, _friendship, _gender, _address, _birthday,
            _Torah, _work, _str, _payment, _attempts){
        ids=_ids; numberOfChildrenU18 = _numberOfChildrenU18;
    }


    /**
    * maximum money this member cauld get from Gemach
     * married community member will pay taxes by the rules
     * assume var =payment/numberOfChild
     * var is bigger than 5000 and under 10000 -> 25 % taxes
     * var is bigger than 10000 -> 50 % taxes
     * Talmid Chacham no taxes to pay
     * @return how much taxes' money to pay to community
     *
     */
    override fun charge():Float {
        if (!((this.works == 0) and (this.Torah > 52) and (this.gender))) {
            var perchild: Float = this.payment / this.numberOfChildrenU18
            if ( perchild < 5000f)
                return 0f
            else if (perchild<10000)
                return 0.25f * payment
                 else
                return 0.5f * payment
        }
        return 0f // Talmid Chacham
    }

    /**
     * maximum money this specific married member can get from Gemach
     * @return amount of money
     */
    override fun deserve_money(): Float {
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
     * U18 is 2-3 -> 15 % of free time
     * U18 is 4 or more -> 1% of free time
     * @return number of hours that fits to the member
     */
    override fun volunteer(): Int {
        var freeTime: Int = 18 * 6 - this.Torah - this.works
        if (numberOfChildrenU18 <= 1)
            return (0.3f * freeTime.toFloat()).toInt()
        else if (numberOfChildrenU18 <= 3)
            return (0.15f * freeTime.toFloat()).toInt()
        else
            if (numberOfChildrenU18 >= 4)
                return (0.01f * freeTime.toFloat()).toInt()
        return 0
    }
}