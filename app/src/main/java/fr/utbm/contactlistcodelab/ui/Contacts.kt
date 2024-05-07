package fr.utbm.contactlistcodelab.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.utbm.contactlist.data.Contact
import fr.utbm.contactlistcodelab.ui.theme.ContactListCodeLabTheme

@Composable
fun ContactListHeader(initial: Char) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 4.dp)
    ) {
        Text(text = initial.toString(), color = Color.DarkGray, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ContactListItem(contact: Contact) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        //modifier = Modifier.clickable { print("on click of item") }
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color(0xFF957fef))
                .size(36.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = getFirstChars(contact.name), color = Color.White)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = contact.name, fontWeight = FontWeight.Medium, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = contact.number,
                fontSize = 14.sp,
                color = Color.Gray
            )

        }

    }
}

fun getFirstChars(name: String): String {
    val words = name.split(" ")
    if (words.size >= 2) {
        val firstWordFirstChar = words[0].first()
        val secondWordFirstChar = words[1].first()
        return "$firstWordFirstChar$secondWordFirstChar"
    } else if (words.size == 1) {
        return words[0].first().toString()
    }
    return ""
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    ContactListCodeLabTheme {

    }
}