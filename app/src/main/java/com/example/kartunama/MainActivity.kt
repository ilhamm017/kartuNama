package com.example.kartunama


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartunama.ui.theme.KartuNamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KartuNamaTheme(true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Profil() {
    // Mrmbuat fungsi Profil yang akan menampilkan Profil utama ( Foto, Nama, dan Titel )
    Column(
        // Ditampilkan dalam Column atau dari atas ke bawah
        horizontalAlignment = Alignment.CenterHorizontally,
        // horizontalAlignment CenterHorizontally membuat konten colum berada di bagian tengah-tengah pada horizontal
        modifier = Modifier.padding()
    ) {
        Image(
            /*Menampilkan image dengan ketentuan
            * Ukuran 120.dp
            * dan ujung tumpul 16.dp
            * */
            painter = painterResource(id = R.drawable.foto_profil),
            contentDescription = "foto profil",
            Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(modifier = Modifier.size(8.dp))
        // Memberikan Spacer sebesar 8.dp
        Text(
            // MEnampilkan text nama Ilham Muliawan dengan ukuran 30.sp
            text = "Ilham Muliawan",
            style = TextStyle(
                fontSize = 30.sp
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            // MEnampilkan text Android Developer dengan ukuran 18.sp dan berwarna hijau tua
            text = "Android Developer",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color(0xFF006400)
            )
        )
    }
}

@Composable
fun Contact() {
    // Membuat fungsi yang akan menampilkan bagian kontak
    val contactInfo = listOf(
        // variabel yang menyimpan data dalam List
        ContactItem(R.drawable.telephone, "+6285156109604", "icon Telephone"),
        ContactItem(R.drawable.share, "@ilhamm017", "icon share"),
        ContactItem(R.drawable.email, "ilhammuliawan26@gmail.com", "icon email")
    )

    Column(
        /* Contact akan ditampilkan dalam colum atau dari atas ke bawah
        * memiliki padding 12.dp
        * memposisikan berada di tengah dengan sejajar bersama icon
        * */
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        // Menampilkan list menggunakan forEach
        contactInfo.forEach { item ->
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.contentDescription,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = item.text)
            }
        }
    }
}
data class ContactItem(val icon: Int, val text: String, val contentDescription: String = "")
/* Membuat kelas baru dengan nama ContactItem yang akan menyimpan
    icon id, text , dan keterangan
*/

@Composable
fun Home() {
    // Fungsi home yang akan menampilkan semua konten dari profil dan contact
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                // membuat Column ini menempati 100% ruang horizontal yang tersedia.
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            // Memposisikan konten profil di tengah secara vertikal
            horizontalAlignment = Alignment.CenterHorizontally
            // Memposisikan konten profil di tengah secara horizontal
        ) {
            Profil()
        }
        Contact()
        // Menempatkan contact di bawah Profil()
        Spacer(modifier = Modifier.size(30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Homepv() {
    Home()
}