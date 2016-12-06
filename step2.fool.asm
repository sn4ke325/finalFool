push 0
push 5
push function0
push function1
push -2
lfp
add
lw
push -2
lfp
add
lw
add
print
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
sub
srv
sra
pop
pop
pop
sfp
lrv
lra
js
