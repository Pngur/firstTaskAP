<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
 xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
<xsl:variable name="newline"><xsl:text>
</xsl:text></xsl:variable>
<xsl:template match="/">NAME,STATUS
<xsl:for-each select="/testng-results/suite/test/class/test-method">
<xsl:value-of select="concat(@name,',')" />
<xsl:value-of select="@status" />
<xsl:value-of select="$newline" />
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>
