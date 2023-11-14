package datos.Usuario

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entidad : Usuario
 *
 * Atributos : nombre, apellido, edad, nombre_usuario, email, contraseña*
 */
@Entity(tableName = "Usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "apellido") val apellido: String,
    @ColumnInfo(name = "edad") val edad: String,
    @ColumnInfo(name = "nombre_usuario") val nombreUsuario: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "contrasena") val contrasena: String
)