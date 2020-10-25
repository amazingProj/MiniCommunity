// Aimed to be an intergradation test.
fun main() {
    //<editor-fold desc="name">
    val bob: Married = Married(
        "111111111",
        _gender = true,
        _address = "New York, 12 ,11",
        _birthday = "1/22/2001",
        _Torah = 33,
        _attempts = 3,
        _payment = 15000f,
        _work = 50,
        _str = "SPIRIT",
        _ids = "4444444444",
        _numberOfChildrenU18 = 5
    )
    val julia: Married = Married(
        "222222222",
        _gender = false,
        _address = "New York, 12 ,15",
        _birthday = "1/22/2001",
        _Torah = 40,
        _attempts = 3,
        _payment = 15000f,
        _work = 30,
        _str = "SPIRIT",
        _ids = "333333333",
        _numberOfChildrenU18 = 10
    )
    val kate = Unmarried(
        "4444444444",
        _gender = false,
        _address = "New York, 12 ,17",
        _birthday = "1/22/2001",
        _Torah = 15,
        _attempts = 3,
        _payment = 15000f,
        _work = 55,
        _str = "MUSICIAN",
        _numberYearsOfStudying = 12
    )
    val chiefRabi = Married(
        id = "333333333",
        _gender = true,
        _address = "New York 12,15"
        , _birthday = "1/2/2001",
        _Torah = 100,
        _work = 1,
        _str = "SPIRIT",
        _payment = 7000f
        , _attempts = 100,
        _ids = "2222222222",
        _numberOfChildrenU18 = 10
    )
// </editor-fold>

    var community: Community = Community(bob, julia, kate)
    community.addCommunityMembers(chiefRabi)

    println(community.totalTaxesAmount())
    println(community.GemachApprovalRequest(bob))
    println(community.sortedHoursofVolunteering())

    val binyamin = Married(
        id = "666666666",
        _gender = true,
        _address = "New York 111,22",
        _birthday = "11/22/2000"
        ,
        _Torah = 60,
        _work = 20,
        _attempts = 3,
        _payment = 10000f,
        _numberOfChildrenU18 = 6,
        _ids = "99999999",
        _str = "PRACTICAL"
    )

    binyamin.example(object : DebtsandRights {
        override fun charge(): Float {

            val b: Boolean = (binyamin.works == 0) and (binyamin.Torah > 52) and (binyamin.gender)
            if ((b)) {
                return 0f
            }// if Talmid Chacham
            var payment:Float = binyamin.payment
            var perchild: Float = payment / binyamin.numberOfChildrenU18

            when (perchild.toInt()) {
                in 0..5000 -> return 0f
                in 5001..10000 -> return (25* payment)/100
            }

            return (50* payment)/100
        }

        override fun desrveMoneyfromGemach(): Float {
            //Talmid Chacham can more easily get extra money from Gemach.
            var payPerChild: Float = binyamin.payment / (binyamin.numberOfChildrenU18+6)//+6
            when {
                payPerChild >= 2000 -> {
                    payPerChild = 0f
                }
                else -> {
                    payPerChild = 2000 - payPerChild
                }
            }
            return ((binyamin.numberOfChildrenU18+6) * (500 + payPerChild) + 1000).toFloat()
        }

        override fun recommendedVolunteerHours(): Int {
            //We all want that Talmid Chacham expend his knowledge
            //Thus, we carefully give him hours
            var freeTime: Int = 20 // Instead of 18*6 - work
            val fraction: (Float) -> Float = { a:Float -> a * freeTime.toFloat() }

            when(binyamin.numberOfChildrenU18){
                in 0..1 -> return fraction(0.3f).toInt()
                in 2..4 ->  return fraction(0.15f).toInt()
            }
            return fraction(0.01f).toInt() // other cases
        }
    })
    community.addCommunityMembers(binyamin);

    println(community.totalTaxesAmount())
    println(community.GemachApprovalRequest(binyamin))
    println(community.sortedHoursofVolunteering())
}
/*
You have joined to the community
Finish with constructing
You have joined to the community
Finish with constructing
You have joined to the community
Finish with constructing
You have joined to the community
Finish with constructing
4500.0
2450
[id number: 111111111Married status          Recommended volunteer hours : 0, id number: 222222222Married status          Recommended volunteer hours : 0, id number: 333333333Married status          Recommended volunteer hours : 1, id number: 4444444444Unmarried status          Recommended volunteer hours : 17]
You have joined to the community
Finish with constructing
4500.0
4200
[id number: 111111111Married status          Recommended volunteer hours : 0, id number: 222222222Married status          Recommended volunteer hours : 0, id number: 333333333Married status          Recommended volunteer hours : 1, id number: 666666666Married status          Recommended volunteer hours : 0, id number: 4444444444Unmarried status          Recommended volunteer hours : 17]

 */

