<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
<html>
<head>
<style>
table{
margin:0 auto;
text-align:center;
border-collapse:collapse;
}
th{
background-color:#42e9f5;
}
.mas90{
background-color:#70fa91;

}

.menos90{
background-color:#86b3f7;
}
</style>

</head>
<body>
		<table border="1">
			<thead>
				<th>Nombre</th>
				<th>Plataforma</th>
				<th>Fecha de salida</th>
				<th>Nota Metacritic</th>
				<th>Nota Usuario</th>
			</thead>
			<tbody>
				<xsl:for-each select="juegos/juego[./plataforma=' Wii']">
				<xsl:sort select="notaMetacritic" order="descending"/>
						<xsl:if test="notaMetacritic&gt;=90">
							<tr class="mas90">
								<td><xsl:value-of select="nombre"/></td>
								<td><xsl:value-of select="plataforma"/></td>
								<td><xsl:value-of select="fechaSalida"/></td>
								<td><xsl:value-of select="notaMetacritic"/></td>
								<td><xsl:value-of select="notaUsuarios"/></td>	
							</tr>	
						</xsl:if>
						<xsl:if test="notaMetacritic&lt;90">
							<tr class="menos90">
								<td><xsl:value-of select="nombre"/></td>
								<td><xsl:value-of select="plataforma"/></td>
								<td><xsl:value-of select="fechaSalida"/></td>
								<td><xsl:value-of select="notaMetacritic"/></td>
								<td><xsl:value-of select="notaUsuarios"/></td>	
							</tr>
						</xsl:if>
				</xsl:for-each>							
			</tbody>
		</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
