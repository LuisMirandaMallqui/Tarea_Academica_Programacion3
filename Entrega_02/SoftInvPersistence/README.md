# SoftInv - Capa de Persistencia

Estructura y estilo espejados de `Clase_5-SoftInvPersistance`:

- Paquetes:
  - `pe.edu.pucp.softinv.dao` → Interfaces DAO por DTO
  - `pe.edu.pucp.softinv.daoImpl` → Implementaciones base (métodos con TODO/UnsupportedOperationException)
  - `pe.edu.pucp.softinv.db.DBManager` → Acceso a conexión (DriverManager, simplificado)

## Dependencia a modelos
Este módulo asume que has instalado localmente `SoftInvModel`:
```bash
cd SoftInvModel
mvn clean install
```

## Compilar esta capa
```bash
cd SoftInv-Persistence
mvn clean package
```

> Ajusta `DBManager` (URL/usuario/password) a tu entorno.

