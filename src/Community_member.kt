/**
 * abstract class represents a community member
 * @property as you can see at the constructor below
 * @property volTypes - enum of types of contribution
 * @property type - local instance of the class enum in this class
 */
abstract class Community_member : Debts_rights {
    private var _id:String=""  //id
      private set
    public var id:String
        set(value) {
            _id = value
        }
        get() = _id

    private var friendship_:Int=0  // 0 for a non member
        private set
    public var friendship:Int //whether or not he is in community
        set(value){
            friendship_ = value
        }
        get() = friendship_



    private var gender_:Boolean=false  //id
        private set
    public var gender:Boolean
        get() = gender_ //gender: true for man
        set(value){gender_ = value}
        //name


   private var address_: String ="" //address
    private set
public var address: String
    get()=address_
    set(value){address_ = value}

    private var birthday_: String ="" //address
        private set
    public var birthday: String //birthday
        get()=birthday_
        set(value){birthday_ = value}

    //learn Torah: hours
   private var Torah_:Int=0 //learn Torah: hours per week
    private  set
   public var Torah:Int //assume that people learn torah per complete hours
       get()=Torah_
    set(value){Torah_=value}

        //works

    private var works_:Int=0 //learn Torah: hours per week
        private  set
    public var works:Int //assume that people learn torah per complete hours
        get()=works_
        set(value){works_=value}


    private var payment_: Float = 0f //working payment
        private set
    public val payment:Float
        get() = payment_

    private var attempts_: Int =0
        private  set
        //Gemach remaining attempts
        get() = attempts_
    public  var attempts:Int
         get() = attempts_
         set(value) {attempts_ = value }

    //Enum: type of volunteering contribution
     enum class volTypes(val contribution: String) { SPIRIT(contribution ="spirit"),
        PRACTICAL(contribution ="practical"), MUSICIAN(contribution ="musician"),NOTYET(contribution = "not yet") }
    private var str_:String =""
          private set
    public var str:String
      get()= str_
      set(value) {str_ = value}

    public var type:volTypes = volTypes.NOTYET // the variable must be initialized

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
    constructor(_id: String, _friendship: Int =0, _gender: Boolean, _address: String, _birthday: String,
                _Torah: Int = 0, _work: Int = 0,_str:String,
                _payment: Float = 0f, _attempts: Int = 0) {
        try {
            id = _id;friendship = _friendship;
            gender = _gender;address = _address;birthday = _birthday;Torah = _Torah;
            works = _work; str = _str; type = volTypes.SPIRIT

            var condition: Float = (2 * 7 * 24).toFloat()/3f
            if ((_work + _Torah).toFloat() < condition)
                throw Exception("must work and learn Torah at least $condition hours per week")
            if ((_Torah / 7) == 0)
                throw Exception("must learn Torah at least one hour per day")
            println("You have joined to the community")
            this.friendship = 1; //you are a member
        } catch (e: Exception) {
            println(e)
            println("Lazy peoople cannot join the community")
            friendship = 0;
        } finally {
            println("Finish with contructing")
        }
    }

}