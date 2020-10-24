/**
 * abstract class represents a community member
 * @property as you can see at the constructor below
 * @property volTypes - enum of types of contribution
 * @property type - local instance of the class enum in this class
 */
abstract class CommunityMember : DebtsandRights {
//region properties
    /*********** properties *********************/

    var id:String=""  //id
        get() = field
        set(v){field=v}

    //whether or not he is in community
    // 0 for a non member
   var friendship:Int=0
        get() = field
         set(v){field = v}



    var gender:Boolean=false
        get() = field //gender: true for man
        set(v){ field =v }
        //name

    //address
   var address: String =""
    get()=field
    set(v){if (v.length <=20)field = v}

    //birthday date
    var birthday: String=""
        get()=field
        set(v){if(v.length <= 20)field=v}

    //learn Jewish subjects: In hours
   //learn Torah: hours per week
   public var Torah:Int =0 //assume that people learn torah per complete hours
       get()=field
        private set(v){if(v >=0)field=v}

    //How many hours spends on working

   var works:Int=0
    get() = field
    private set(v) {if (v>=0)field=v}

    var payment:Float = 0f
        get() = field
        private set(v) {if (v >= 0f) field = v}

     var attempts:Int=0
         get() = field
         set(v) {if (v>=0)field  = v }

    //Enum: type of volunteering contribution
     public enum class volTypes { SPIRIT, PRACTICAL, MUSICIAN }
    fun getVolTypesbyName(name:String) = volTypes.valueOf(name)
    fun getVolTypes() = volTypes.valueOf(str)

     var str:String =""
      get()= field
      set(value) {field = value}

//endregion

    /**************** c'ctor **********************/

    /**
     * @author assaf Hillel
     * @param id - identify number
     * @param _friendship - if he is a member then equals one. default value 0 - non a member at all
     * @param _gender - true for a man false for a female
     * @param _address - current address
     * @param _birthday member's birthday date
     * @param _Torah amount of  hours of learning Torah per week
     * @param _work amount of hours of working per week
     * @param _str the name type of what kind of contribution to community
     * @param _payment salary's high
     * @param _attempts number of pulling Gemach requests which is allowed
     * @exception regular_exception he works and learn less time than proper amount
     * @exception regular_exception do not learn one hours per day Torah
     */
    constructor(
        _id: String,
        _friendship: Int =0,
        _gender: Boolean,
        _address: String,
        _birthday: String,
        _Torah: Int ,
        _work: Int ,
        _str:String,
        _payment: Float ,
        _attempts: Int
    ) {
        try {
            id = _id;friendship = _friendship;
            gender = _gender;address = _address;birthday = _birthday;Torah = _Torah;
            works = _work;payment =_payment; str = _str; volTypes.valueOf(str);attempts = _attempts

            var condition: Float = ( 6 * 18 +9).toFloat()/3f
            if ((_work + _Torah).toFloat() < condition)
                throw Exception("must work and learn Torah at least $condition hours per week")
            if ((_Torah / 7) == 0)
                throw Exception("must learn Torah at least one hour per day")
            println("You have joined to the community")
            this.friendship = 1; //you are a member
        } catch (e: Exception) {
            println(e)
            println("Lazy people cannot join the community")
            friendship = 0;
        } finally {
            println("Finish with constructing")
        }
    }

    /**************** functions *********************/

    //object expression
    fun example(impInterface: DebtsandRights){
        impInterface.charge()
        impInterface.desrveMoneyfromGemach()
        impInterface.recommendedVolunteerHours()
    }


    override fun toString(): String {
        return "id number: $id"
    }


}
