package fr.utbm.contactlist.data

import net.datafaker.Faker
import java.util.Locale

object ContactProvider {
    //instance of Faker
    val faker = Faker(Locale.FRANCE)

    val contacts = (1..50).map {
        val name = faker.name().fullName()
        val number = faker.phoneNumber().phoneNumberInternational()
        Contact(name, number)
    }

    //grouped
    val groupedContacts = contacts.sortedBy { it.name.first() }.groupBy { it.name.first() }

}