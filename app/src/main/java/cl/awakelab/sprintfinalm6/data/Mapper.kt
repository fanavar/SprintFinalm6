package cl.awakelab.sprintfinalm6.data

import cl.awakelab.sprintfinalm6.data.local.PhoneEntity
import cl.awakelab.sprintfinalm6.data.remote.Phone

fun Phone.toPhoneEntity(): PhoneEntity {
    return PhoneEntity(
        id = this.id,
        name = this.name,
        price = this.price,
        image = this.image,
        credit = this.credit
    )
}

//función de extensión
