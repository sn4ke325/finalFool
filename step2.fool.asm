push 0
lfp
push function0
lfp
push function1
push -2
lfp
add
lw
push -2
lfp
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
sfp
pop
pop
pop
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
sfp
pop
pop
pop
lrv
lra
js
