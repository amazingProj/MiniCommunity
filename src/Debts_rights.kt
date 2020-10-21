/**
 * interface represents debts and rights of a single member at the community
 */
interface Debts_rights {
    fun charge():Float// calc of tax charge
    fun deserve_money():Float//maximum received money
    fun volunteer():Int//number of hours of volunteering
}