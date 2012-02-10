#!/bin/bash
#
#	go.sh - compiles and runs the program
#

JAVA=$(which java)
JAVAC=$(which javac)

SRC=src/
BIN=bin/

BOOTSTRAP_SRC=src/com/sortable/challenge/Bootstrap.java
BOOTSTRAP=com.sortable.challenge.Bootstrap

LISTING_BY_PRODUCT=listing_by_product.txt

if [ x == x$JAVA ]; then
  echo Java is required
  exit 1
fi

if [ x == x$JAVAC ]; then
  echo Javac is required
  exit 1
fi

rm -rf $BIN $LISTING_BY_PRODUCT
mkdir $BIN

$JAVAC -sourcepath $SRC -d $BIN $BOOTSTRAP_SRC

$JAVA -cp $BIN $BOOTSTRAP $*
