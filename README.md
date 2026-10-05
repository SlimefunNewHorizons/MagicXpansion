<p align="center"><img src="https://raw.githubusercontent.com/SlimefunNewHorizons/MagicXpansion/main/banner.svg" alt="MagicXpansion" width="100%"></p>

# MagicXpansion

> ### 🏰 ¡Únete a la Comunidad Oficial de DrakesCraft!
> 
> * 🎮 **IP del Servidor**: `play.drakescraft.net` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord Oficial**: [discord.gg/drakescraft](https://discord.gg/rv3vtXZTk7)
> * 🌐 **Web & Guía**: [drakescraft.net](https://drakescraft.net) — 🛒 **Tienda**: [tienda.drakescraft.net](https://tienda.drakescraft.net)
> 
> *¡Juega con este addon y más de 80 expansiones optimizadas en vivo en nuestra network de supervivencia técnica!*

---

Magia, hechizos y maquinaria arcana para Slimefun, adaptado al ecosistema de **DrakesCraft**
(Paper/Purpur 1.21.11, Java 21).

## Qué añade

Veintinueve objetos repartidos en siete categorías — general, recursos, objetos mágicos,
herramientas, armas, armaduras y máquinas — colgando de un menú principal propio.

Entre ellos, lingotes de **Arcanium** y de **aleación de Shulker**, un **Reactor de Almas**,
un **Generador Mágico** que quema grumos del End como combustible, y varios **grimorios** con
hechizos.

## Qué cambiamos

Este repositorio **no es un fork**: es el código original integrado en el ecosistema de
DrakesCraft. Los cambios son estos.

**Dependía de la versión de upstream de otro addon.** El pom apuntaba a `FoxyMachines` de
GallowsDove, compilado contra los paquetes originales de Slimefun. Eso arrastraba al classpath
tipos como `me.mrCookieSlime.Slimefun.api.SlimefunItemStack`, que aquí no existen — y el síntoma
engañaba, porque los errores salían en *nuestro* código aunque el problema estuviese en el jar
del vecino. Ahora apunta a nuestro port, que además es el que corre en el servidor.

**InfinityLib pasó de la 1.2 a la 1.3.** Cambió de sitio media librería: `AbstractAddon` y las
métricas se movieron de paquete, `SubCategory` y `MultiCategory` pasaron a llamarse `SubGroup` y
`MultiGroup` bajo `groups`, y `onEnable`/`onDisable` se volvieron finales — el punto de entrada
del addon es ahora `enable()`.

**`Category` dejó paso a `ItemGroup`.** `SubGroup` hereda de `ItemGroup`, no de la `Category`
obsoleta, así que declarar los grupos como `Category` ya no encajaba.

**`ProtectableAction` se llama hoy `Interaction`**, y `SlimefunPlugin.runSync` se movió a
`Slimefun.runSync`.

**`addFlags` desapareció de la API.** Se sustituye por `Banderas`, un ayudante de este mismo jar
que pasa por el `ItemMeta`. Solo puede usarse mientras se define el objeto: un `SlimefunItemStack`
se bloquea al registrarse y a partir de ahí lanza excepción.

**El identificador `ENDER_LUMP_4` chocaba con un objeto ya registrado en el servidor.** Dos
addons no pueden registrar el mismo identificador: Slimefun rechaza el segundo y se queda sin
objeto, lo que habría roto sus recetas y el combustible del Generador Mágico. Aquí se registra
como `MX_ENDER_LUMP_4`.

## Pendiente

**El nombre visible del grumo sigue siendo `Ender Lump - IV`**, igual que el del objeto que ya
existe en el servidor. Son objetos distintos con el mismo rótulo, lo cual no rompe nada pero se
presta a confusión en la guía.

**El autoactualizador está desarmado** desde nuestra InfinityLib: estos jars están recompilados
contra el Slimefun repaquetado del servidor, y bajarse el de upstream encima dejaría el addon sin
cargar. Las actualizaciones se despliegan por SFTP, como el resto.

## Créditos

Addon original de **Apeiros-46B**. Este repositorio solo lo adapta.

---

## 📄 License & Upstream Attribution

This project is a sovereign fork maintained by [**JackStar6677-1**](https://github.com/JackStar6677-1) under [**DrakesCraft Labs**](https://github.com/SlimefunNewHorizons).

- **Original Project:** Created by the upstream authors and the open-source community.
- **DrakesCraft Optimizations:** Modernized for Paper/Purpur 1.21.11+, Java 21, high concurrency, asynchronous safety, and exploit/duplication prevention.
- **License:** Distributed under the original **GNU General Public License v3.0 (GPLv3)** (or original upstream license). See the [LICENSE](LICENSE) file for complete terms.
