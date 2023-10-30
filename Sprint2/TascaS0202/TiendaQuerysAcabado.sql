-- 1.Llista el nom de tots els productes que hi ha en la taula producto.
SELECT nombre FROM producto;

-- 2.Llista els noms i els preus de tots els productes de la taula producto.
SELECT nombre,precio FROM producto;

-- 3.Llista totes les columnes de la taula producto.
SELECT * FROM producto;
-- 4.Llista el nom dels productes, el preu en euros i el preu en dòlars estatunidencs (USD).
SELECT nombre,precio,FORMAT((precio*1.06),2) FROM producto;

-- 5.Llista el nom dels productes, el preu en euros i el preu en dòlars estatunidencs (USD). Utilitza els següents àlies per a les columnes: nom de producto, euros, dòlars.
SELECT nombre as producto ,precio as euros,FORMAT((precio*1.06),2) as dolar FROM producto;

-- 6.Llista els noms i els preus de tots els productes de la taula producto, convertint els noms a majúscula.
SELECT UPPER(nombre), precio FROM producto;

-- 7.Llista els noms i els preus de tots els productes de la taula producto, convertint els noms a minúscula.
SELECT LOWER(nombre), precio FROM producto;

-- 8.Llista el nom de tots els fabricants en una columna, i en una altra columna obtingui en majúscules els dos primers caràcters del nom del fabricant.
SELECT nombre,UPPER(LEFT(nombre,2)) FROM fabricante;

-- 9.Llista els noms i els preus de tots els productes de la taula producto, arrodonint el valor del preu.
SELECT nombre,ROUND(precio) FROM producto;

-- 10.Llista els noms i els preus de tots els productes de la taula producto, truncant el valor del preu per a mostrar-lo sense cap xifra decimal.
SELECT nombre,TRUNCATE(precio,0) FROM producto;

-- 11.Llista el codi dels fabricants que tenen productes en la taula producto.
SELECT codigo_fabricante FROM producto;

-- 12.Llista el codi dels fabricants que tenen productes en la taula producto, eliminant els codis que apareixen repetits.
SELECT DISTINCT codigo_fabricante FROM producto;

-- 13.Llista els noms dels fabricants ordenats de manera ascendent.
SELECT  nombre  FROM fabricante ORDER BY nombre ASC ;

-- 14.Llista els noms dels fabricants ordenats de manera descendent.
SELECT  nombre  FROM fabricante ORDER BY nombre ASC ;

-- 15.Llista els noms dels productes ordenats, en primer lloc, pel nom de manera ascendent i, en segon lloc, pel preu de manera descendent.
SELECT  nombre,precio FROM producto ORDER BY nombre ASC, precio DESC ;
 
-- 16.Retorna una llista amb les 5 primeres files de la taula fabricante.
SELECT * FROM fabricante LIMIT 5;

-- 17.Retorna una llista amb 2 files a partir de la quarta fila de la taula fabricante. La quarta fila també s'ha d'incloure en la resposta.
SELECT * FROM fabricante LIMIT 2 OFFSET 3;

-- 18.Llista el nom i el preu del producte més barat. (Utilitza solament les clàusules ORDER BY i LIMIT). NOTA: Aquí no podria usar MIN(preu), necessitaria GROUP BY.
SELECT nombre,precio FROM producto ORDER BY precio ASC LIMIT 1;

-- 19.Llista el nom i el preu del producte més car. (Utilitza solament les clàusules ORDER BY i LIMIT). NOTA: Aquí no podria usar MAX(preu), necessitaria GROUP BY.
SELECT nombre,precio FROM producto ORDER BY  precio DESC LIMIT 1 ;

-- 20.Llista el nom de tots els productes del fabricant el codi de fabricant del qual és igual a 2.
SELECT nombre FROM producto WHERE codigo_fabricante=2;

-- 21.Retorna una llista amb el nom del producte, preu i nom de fabricant de tots els productes de la base de dades.
SELECT nombre,precio,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) AS fabricante FROM producto;

-- 22.Retorna una llista amb el nom del producte, preu i nom de fabricant de tots els productes de la base de dades. Ordena el resultat pel nom del fabricant, per ordre alfabètic.
SELECT nombre,precio,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) AS fabricante FROM producto ORDER BY fabricante ASC;

-- 23.Retorna una llista amb el codi del producte, nom del producte, codi del fabricador i nom del fabricador, de tots els productes de la base de dades.
SELECT codigo,nombre,(select codigo FROM fabricante WHERE codigo=producto.codigo_fabricante) as CodigoFabricante,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as NombreFabricante FROM producto;

-- 24.Retorna el nom del producte, el seu preu i el nom del seu fabricant, del producte més barat.
SELECT nombre,precio,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as NombreFabricante FROM producto ORDER BY precio ASC LIMIT 1;

-- 25.Retorna el nom del producte, el seu preu i el nom del seu fabricant, del producte més car.
SELECT nombre,precio,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as NombreFabricante FROM producto ORDER BY precio DESC LIMIT 1;

-- 26.Retorna una llista de tots els productes del fabricant Lenovo.
-- con un varios SELECT * ,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as NombreFabricante FROM producto WHERE codigo_fabricante=2;
SELECT * FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre='Lenovo';

-- 27.Retorna una llista de tots els productes del fabricant Crucial que tinguin un preu major que 200 €.
-- con un varios SELECT * ,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as nombreFabricante FROM producto WHERE codigo_fabricante=6 AND precio>200;
SELECT * FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre='Lenovo' AND p.precio>200;

-- 28.Retorna un llistat amb tots els productes dels fabricants Asus, Hewlett-Packardy Seagate. Sense utilitzar l'operador IN.
-- con un varios SELECT * ,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as nombreFabricante FROM producto WHERE codigo_fabricante=1 OR  codigo_fabricante=3 OR codigo_fabricante=5;
SELECT * FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre='Lenovo' OR f.nombre='Hewlett-Packard' OR f.nombre='Seagate' ;

-- 29.Retorna un llistat amb tots els productes dels fabricants Asus, Hewlett-Packardy Seagate. Fent servir l'operador IN.
-- con varios SELECT * ,(select nombre FROM fabricante WHERE codigo=producto.codigo_fabricante) as nombreFabricante FROM producto WHERE codigo_fabricante IN  (1,3,5);
SELECT * FROM producto p INNER JOIN fabricante f ON p.codigo_fabricante=f.codigo WHERE f.nombre IN ('Lenovo','Hewlett-Packard','Seagate') ;

-- 30.Retorna un llistat amb el nom i el preu de tots els productes dels fabricants el nom dels quals acabi per la vocal e.
SELECT p.nombre,p.precio,f.nombre as nombreFabricante FROM producto p
JOIN fabricante f on p.codigo_fabricante=f.codigo
WHERE f.nombre LIKE '%e';


-- 31.Retorna un llistat amb el nom i el preu de tots els productes el nom de fabricant dels quals contingui el caràcter w en el seu nom.
SELECT p.nombre,p.precio,f.nombre as nombreFabricante FROM producto p
JOIN fabricante f on p.codigo_fabricante=f.codigo
WHERE f.nombre LIKE '%w%';

-- 32.Retorna un llistat amb el nom de producte, preu i nom de fabricant, de tots els productes que tinguin un preu major o igual a 180 €. Ordena el resultat, en primer lloc, pel preu (en ordre descendent) i, en segon lloc, pel nom (en ordre ascendent).
SELECT p.nombre,p.precio,f.nombre as nombreFabricante FROM producto p
JOIN fabricante f on p.codigo_fabricante=f.codigo
WHERE p.precio>=180 
ORDER BY p.precio DESC, p.nombre ASC;

-- 33.Retorna un llistat amb el codi i el nom de fabricant, solament d'aquells fabricants que tenen productes associats en la base de dades.
SELECT distinct f.codigo,f.nombre FROM fabricante f
JOIN producto p ON  p.codigo_fabricante=f.codigo;

-- 34.Retorna un llistat de tots els fabricants que existeixen en la base de dades, juntament amb els productes que té cadascun d'ells. El llistat haurà de mostrar també aquells fabricants que no tenen productes associats.
SELECT  f.codigo,f.nombre,p.nombre FROM fabricante f
left JOIN producto p ON  p.codigo_fabricante=f.codigo;

-- 35.Retorna un llistat on només apareguin aquells fabricants que no tenen cap producte associat.
SELECT  f.codigo,f.nombre,p.nombre FROM fabricante f
LEFT JOIN producto p ON  p.codigo_fabricante=f.codigo where p.codigo_fabricante IS NULL;

-- 36.Retorna tots els productes del fabricador Lenovo. (Sense utilitzar INNER JOIN).
SELECT nombre,precio FROM producto p WHERE EXISTS( SELECT f.nombre FROM fabricante f WHERE f.codigo=p.codigo_fabricante AND f.nombre='Lenovo');

-- 37.Retorna totes les dades dels productes que tenen el mateix preu que el producte més car del fabricant Lenovo. (Sense usar INNER JOIN).
SELECT * FROM producto WHERE precio=(SELECT MAX(precio) FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo'));

-- 38.Llista el nom del producte més car del fabricant Lenovo.
SELECT nombre FROM producto WHERE precio=(SELECT MAX(precio) FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo'));

-- 39.Llista el nom del producte més barat del fabricant Hewlett-Packard.
SELECT nombre FROM producto WHERE precio=(SELECT MIN(precio) FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Hewlett-Packard'));

-- 40.Retorna tots els productes de la base de dades que tenen un preu major o igual al producte més car del fabricant Lenovo.
SELECT nombre FROM producto WHERE precio>=(SELECT MAX(precio) FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Lenovo'));

-- 41.Llesta tots els productes del fabricant Asus que tenen un preu superior al preu mitjà de tots els seus productes.
SELECT nombre FROM producto WHERE precio>(SELECT AVG(precio) FROM producto WHERE codigo_fabricante=(SELECT codigo FROM fabricante WHERE nombre='Asus'));

