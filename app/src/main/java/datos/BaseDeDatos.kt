package datos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import datos.Usuario.Usuario
import datos.Usuario.UsuarioDao

@Database(entities = [Usuario::class], version = 1, exportSchema = true)
abstract class BaseDeDatos: RoomDatabase() {

    abstract fun UsuarioDao(): UsuarioDao

    /**
        Explicación :

        Companion object : Es un bloque similar al tener un bloque 'static' en Java

        Este bloque de codigo hace uso de un patron de diseño llamado 'Singleton', donde
     este patron asegura que una clase tenga solo una instancia y proporcione un punto global de acceso,
     esto con el fin de garantizar que la concurrencia se maneje de manera adecuada para evitar conflictos.
     */
    companion object {
        @Volatile
        private var INSTANCE: BaseDeDatos? = null
        fun getDatabase(context: Context): BaseDeDatos {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    BaseDeDatos::class.java,
                    "app_database"
                )
                    .build()
                INSTANCE = instance

                instance
            }

        }
    }
}