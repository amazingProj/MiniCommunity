/*
/**
 * Community member class for the community that includes members:
 * married and unmarried
 * @constructor construct a community
 * @author assaf Hillel
 *
 */
class Community {
    /**
     * the class community has a list of her community members
     */
    public var communityMembers: MutableList<Community_member> ?= (null)
        get() = communityMembers

    /**
     * construct a community by firstly construct a list of members
     * @param values an unlimited amount of community members
     * @return void constructing a community by values
     * @suppress frist puting new argument to a null list
     */
    constructor(vararg values: Community_member){
        if(!(communityMembers.isNullOrEmpty()))
            communityMembers?.clear()
       //communityMembers.addAll(values)
    }



    /**
     *  add few community members
     *  @param values adding members unlimitedly
     *  @return void just doing manipulation on community's list
     *  @suppress frist puting new argument to a null list
     */
    fun addCommunityMembers(vararg values: Community_member) {
        for (v: Community_member in values) {
            addANewMember(v)
        }
        //communityMembers.addAll(values)
    }

    /**
     * add a new member
     * @param s member to add
     * @return void adding a new member
     * @suppress frist puting new argument to a null list
     */
    fun addANewMember(s: Community_member) {
       // communityMembers.add(s)
    }

    /**
     *
     */
    fun total_taxes_amount():Float {
        var total:Float = 0f
        for (v: Community_member in communityMembers) {
                  total += v.charge()
        }
       return total
        return  0f
    }

    /**
     * Each community member has maximum amount of money
     * if his payment is lower than 8000 then he immediatly  get the maximum amount
     * another option to get money :he works and learns Torah above 30 hours he will get 70 %  of the maximum
     * if he/she is not one of the above only 30 %
     * @param mem - represents the community member which pull the request
     * @return money that he/she could get
     */
    fun Gemach_approval_request(mem:Community_member) : Int {
        if (!(mem.attempts == 0)){
        val calcMoney: (Float) -> Float = { a: Float -> a * mem.deserve_money().toFloat() }
        var mo: Float = 0f //Init of var
        if (mem.payment < 8000) {
            mo = calcMoney(1f)
        } else
            if ((mem.works > 0) and (mem.Torah > 30)) {
                mo = calcMoney(0.7f)
            } else mo = calcMoney(0.3f)
        mem.attempts--
        return mo.toInt()
    }
    return 0; //if there is no attempts avaible
    }

    /**
     *
     */
    fun sorted_hours_of_volunteering() : MutableList<Community_member>{
        var volunteers: MutableList<Community_member> = mutableListOf()
        var lambda = {_str:String ->  for (v in communityMembers){
            if(v.str == _str)
                volunteers.add(v)
        }}
        lambda("spirit")
        lambda("practical")
        lambda("musician")
        return  volunteers
    }

}
*/
