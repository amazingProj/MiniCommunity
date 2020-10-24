/**
 * Community member class for the community that includes members:
 * married and unmarried
 * @constructor construct a community
 * @author assaf Hillel
 *
 */
class Community {

    /******************properties **********/
    /**
     * the class community has a list of her community members
     */
    public var communityMembers: MutableList<CommunityMember> = mutableListOf()

    // ?= (null)
    //  get() = communityMembers
    operator fun iterator(): Iterator<CommunityMember> {             // 1
        return communityMembers.iterator()                           // 2
    }

    /*************** constuctor ******************/

    /**
     * construct a community by firstly construct a list of members
     * @param values an unlimited amount of community members
     * @return void constructing a community by values
     * @suppress frist puting new argument to a null list
     */
    constructor(vararg values: CommunityMember) {
        if (!(communityMembers.isNullOrEmpty()))
            communityMembers?.clear()
        communityMembers.addAll(values)
    }

    /******************* function *********************/

    /**
     *  add few community members
     *  @param values adding members unlimitedly
     *  @return void just doing manipulation on community's list
     *  @suppress frist puting new argument to a null list
     */
    fun addCommunityMembers(vararg values: CommunityMember) {
        communityMembers.addAll(values)
    }

    /**
     * function calculate the total amount of charging taxes
     * @return total - amount of money of taxes
     */
    fun totalTaxesAmount(): Float {
        var total: Float = 0f
        for (v: CommunityMember in communityMembers) {
            total += v.charge()
        }
        return total
        return 0f
    }

    /**
     * Each community member has maximum amount of money
     * if his payment is lower than 8000 then he immediatly  get the maximum amount
     * another option to get money :he works and learns Torah above 30 hours he will get 70 %  of the maximum
     * if he/she is not one of the above only 30 %
     * @param mem - represents the community member which pull the request
     * @return money that he/she could get
     */
    fun GemachApprovalRequest(mem: CommunityMember): Int {
        if (mem.attempts == 0)
            return 0; //if there is no attempts available

        val calcMoney = { a: Float -> a * mem.desrveMoneyfromGemach().toFloat() }
        var mo = 0f //Init of var
        when {
            mem.payment < 8000 -> {
                mo = calcMoney(1f)
            }
            (mem.works > 0) and (mem.Torah > 30) -> {
                mo = calcMoney(0.7f)
            }
            else -> mo = calcMoney(0.3f)
        }
        mem.attempts--
        return mo.toInt()
    }

    /**
     * each community member has a contribution this function
     *@return a sorted list -  types by this order  the first is spiritual contribution members and then
     * practical contribution members  and musician contribution members
     */
    fun sortedHoursofVolunteering(): MutableList<CommunityMember> {
        var volunteers: MutableList<CommunityMember> = mutableListOf()
        var lambda: (srt: String) -> Unit = { str: String ->
            for (v in communityMembers) {
                if (v.getVolTypes().toString() == v.getVolTypesbyName(str).toString()) {
                    volunteers.add(v)
                }
            }
        }
        lambda("SPIRIT")
        lambda("PRACTICAL")
        lambda("MUSICIAN")
        return volunteers
    }
}


