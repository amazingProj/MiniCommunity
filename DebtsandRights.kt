/**
 * interface represents debts and rights of a single member at the community
 */
interface DebtsandRights {
    fun charge():Float// calc of tax charge
    fun desrveMoneyfromGemach():Float//maximum received money
    fun recommendedVolunteerHours():Int//number of hours of volunteering that recommended
}