/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inlab4;

/**
 *
 * @author risau
 */
public class RecordCompany
{
Band myBand;
public RecordCompany(Band t)
{
myBand = t;
}
 public Band getBand()
 {
 return myBand;
 }
public String getAlbum()
{
 return myBand.getAlbum();
}
public void changeAlbum(String x)
{ myBand.changeAlbum(x); }
}

